package com.sabapathy.tutorial.controller;

import com.sabapathy.tutorial.model.Account;
import com.sabapathy.tutorial.model.User;
import com.sabapathy.tutorial.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UpdateController {
    Logger logger = LoggerFactory.getLogger(UpdateController.class);

    @Autowired
    public UserService userService;

    private boolean verifyCaptcha(HttpServletRequest request) {
        String generatedCaptcha = request.getSession().getAttribute("captchaSecurityCode").toString();
        String userEnteredCaptcha = request.getParameter("captcha");
        return generatedCaptcha.equals(userEnteredCaptcha);
    }

    private boolean verifyPassword(HttpServletRequest request) {
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        return password != null && password.equals(repassword);
    }

    @RequestMapping(value = "/updateProcess", method = RequestMethod.POST)
    public ModelAndView updateProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("account") Account account) {
        if (!verifyCaptcha(request)) {
            logger.debug("Captcha failed during update for user " + account.getName());

            ModelAndView mav = new ModelAndView("update");
            mav.addObject("message", "Incorrect captcha - Please enter again!");
            return mav;
        }

        if (!verifyPassword(request)) {
            logger.debug("Password re-enter mismatch, during update for user " + account.getName());

            ModelAndView mav = new ModelAndView("update");
            mav.addObject("message", "Passwords don't match - Please enter again!");
            return mav;
        }

        User user = new User(account.getName(), account.getEmail(), account.getUsername(), account.getPassword(), null, false);
        userService.update(user);

        ModelAndView mav = new ModelAndView("welcome", "name", account.getName());
        mav.addObject("message", "Your account has been updated!");
        return mav;
    }
}
