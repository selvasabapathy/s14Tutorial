package com.sabapathy.tutorial.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sabapathy.tutorial.model.Login;
import com.sabapathy.tutorial.model.User;
import com.sabapathy.tutorial.service.UserService;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {

        User user = userService.login(login);

        ModelAndView mav;
        if (null != user) {
            mav = new ModelAndView("welcome");
            mav.addObject("name", user.getName());
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "No user found with the given Username and/or!");
        }
        return mav;
    }
}
