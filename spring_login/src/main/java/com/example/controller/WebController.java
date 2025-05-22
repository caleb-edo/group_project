package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller // This annotation indicates that the class is a web controller
public class WebController {

    @RequestMapping(value = "/") // This annotation maps HTTP requests to the home() method if the request's URL is "/"
    @PreAuthorize("hasAuthority('SCOPE_profile')") // This annotation ensures that the userDetails() method can only be accessed by users with the 'SCOPE_profile' authority
    public String userDetails(Model model, OAuth2AuthenticationToken token) {
        model.addAttribute("username", token.getPrincipal().getName()); // Adds the username to the model
        model.addAttribute("details", token.getPrincipal().getAttributes()); // Adds the user's details to the model
        model.addAttribute("principal_given_name",
                token.getPrincipal().getAttributes().get("given_name")); // Adds the user's given name to the model
        return "start"; // Returns the name of the view (in this case "profile")


    }


}