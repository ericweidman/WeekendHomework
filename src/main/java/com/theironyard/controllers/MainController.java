package com.theironyard.controllers;

import com.theironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by ericweidman on 3/10/16.
 */
@Controller
public class MainController {
    @Autowired
    UserRepository users;


}
