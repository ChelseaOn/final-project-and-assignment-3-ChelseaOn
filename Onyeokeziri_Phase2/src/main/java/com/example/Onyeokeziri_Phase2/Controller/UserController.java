package com.example.Onyeokeziri_Phase2.Controller;

import com.example.Onyeokeziri_Phase2.Models.User;
import com.example.Onyeokeziri_Phase2.Models.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

//Implements Homepage:Login and Registration buttons

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }
    //Implements Registration form page:Create new user
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }
//Implements successful registration page: User is sent to page once registered successfully where they can login
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "registration_success";
    }
}
