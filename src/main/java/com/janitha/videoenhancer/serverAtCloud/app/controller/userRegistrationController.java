package com.janitha.videoenhancer.serverAtCloud.app.controller;

import com.janitha.videoenhancer.serverAtCloud.formLogin.Model.User;
import com.janitha.videoenhancer.serverAtCloud.securingweb.SecurityUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
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


    @GetMapping("/")
    public String index() {
        return "index";
    }

    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        session.setAttribute(
                "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
        );
        return "login";
    }

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
