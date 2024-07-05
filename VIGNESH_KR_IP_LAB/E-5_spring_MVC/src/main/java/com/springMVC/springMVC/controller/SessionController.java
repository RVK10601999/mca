package com.springMVC.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    @GetMapping("/hello")
    public String hello(Model model, HttpSession session) {
        // Retrieve a counter from the session, or initialize it if not present
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }

        // Increment the counter and store it back in the session
        counter++;
        session.setAttribute("counter", counter);

        // Pass the counter value to the view
        model.addAttribute("counter", counter);

        return "hello";
    }
}