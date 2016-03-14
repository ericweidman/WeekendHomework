package com.theironyard.controllers;

import com.theironyard.entities.Job;
import com.theironyard.entities.User;
import com.theironyard.services.JobRepository;
import com.theironyard.services.UserRepository;
import com.theironyard.utils.PasswordStorage;
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
    JobRepository jobs;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);
        model.addAttribute("user", user);
        model.addAttribute("jobs", jobs.findAll());
        return "home";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) throws Exception {
        User user = users.findFirstByName(userName);
        if (user == null) {
            user = new User(userName, PasswordStorage.createHash(password));
            users.save(user);
        } else if (!PasswordStorage.verifyPassword(password, user.getPasswordHash())) {
            throw new Exception("Invalid password!");
        }
        session.setAttribute("userName", userName);
        return "redirect:/";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(HttpSession session, String companyName, String url, String dateApplied) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);
        Job job = new Job(companyName, url, dateApplied, user);
        jobs.save(job);
        return "redirect:/";
    }
    @RequestMapping(path = "/remove", method = RequestMethod.POST)
    public String remove(HttpSession session, int id) {
        session.setAttribute("id", id);
        jobs.delete(id);
        return "redirect:/";
    }
    @RequestMapping(path = "/editJob", method = RequestMethod.GET)
    public String edit(Model model, int editId){
        Job editJob = jobs.findOne(editId);
        model.addAttribute("jobs", editJob);
        return "edit";
    }
    @RequestMapping(path = "/editJob", method = RequestMethod.POST)
    public String edit(int editId, String editCompany, String editUrl, String editDateApplied){
        Job job = jobs.findOne(editId);
        job.companyName = editCompany;
        job.url = editUrl;
        job.dateApplied = editDateApplied;
        jobs.save(job);
        return "redirect:/";
    }
}
