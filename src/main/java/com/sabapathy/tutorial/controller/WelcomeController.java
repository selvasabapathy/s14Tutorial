package com.sabapathy.tutorial.controller;

import com.sabapathy.tutorial.model.Account;
import com.sabapathy.tutorial.model.Login;
import com.sabapathy.tutorial.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomeController {
    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    private boolean isAdmin(User user) {
        logger.debug("Is user {} an Admin? {}", user.getName(), user.isAdmin());
        return user.isAdmin();
    }

    private User getCurrentUser(HttpServletRequest request) {
        return ((User)request.getSession().getAttribute("currentUser"));
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(HttpServletRequest request, HttpServletResponse response) {
        User user  = getCurrentUser(request);
        if (!isAdmin(user)) {
            ModelAndView mav = new ModelAndView("welcome");
            mav.addObject("name", user.getName());
            mav.addObject("message", "Not allowed - restricted to Admin use");
            return mav;
        }

        ModelAndView mav = new ModelAndView("admin");
        mav.addObject("name", ((User)request.getSession().getAttribute("currentUser")).getName());
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
        User user  = getCurrentUser(request);
        Account account = new Account(user.getName(), user.getEmail(), user.getUsername(), user.getPassword(), null, null);

        ModelAndView mav = new ModelAndView("update");
        mav.addObject("account", account);
        return mav;
    }
}
