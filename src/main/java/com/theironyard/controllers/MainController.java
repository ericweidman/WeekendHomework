package com.theironyard.controllers;

import com.theironyard.entities.Job;
import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by ericweidman on 3/10/16.
 */
@Controller
public class MainController {
    @Autowired
    UserRepository users;

    @Autowired
    Job jobs;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model){
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);

        return "home";
    }
}
