package com.janitha.videoenhancer.serverAtCloud.app.controller;

import com.janitha.videoenhancer.serverAtCloud.formLogin.Model.User;
import com.janitha.videoenhancer.serverAtCloud.securingweb.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class userRegistrationController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityUserDetailsService userDetailsManager;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping(value = "/register")
    public ModelAndView addUser(@RequestParam Map<String, String> body)
    {


        User user = new User();
        user.setUsername(body.get("username"));
        user.setPassword(passwordEncoder.encode(body.get("password")));
        user.setAccountNonLocked(true);
        if(userDetailsManager.isUserExist(user))
            return new ModelAndView("redirect:register?exist" );
        if(userDetailsManager.createUser(user))
            return new ModelAndView("redirect:register?success" );
        return new ModelAndView("redirect:register?error" );
        //return "register?error";
    }



}
