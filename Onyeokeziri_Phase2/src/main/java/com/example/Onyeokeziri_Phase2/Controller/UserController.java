package com.example.Onyeokeziri_Phase2.Controller;

import com.example.Onyeokeziri_Phase2.Models.User;
import com.example.Onyeokeziri_Phase2.Models.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
    @GetMapping("/login")
    public String ModelandView() { return "login" ;}

    @RequestMapping(value="/postlogin", method= RequestMethod.POST)
    public ModelAndView postlogin(@RequestParam("userID") String un, @RequestParam("password") String pwd){
        ModelAndView mv = null;
        boolean nouser=false;
        Optional<User> u = userRepo.findById();
        if (u.isPresent()) {
            boolean npwd=false;
            User u1 = u.get();
            if ((!u1.getPassword().equals(pwd))) {
                npwd=true;
                mv = new ModelAndView("login");
                String pwdmessage="'Check your password";
                mv.addObject("pwdNomatch", npwd);
                mv.addObject("pwderror",pwdmessage );
                return mv;

            }
            if (u1.getRole().equals("admin")) {
                mv = new ModelAndView("redirect:/adminView"); //redirect to admin view page for admin users
            } else if (u1.getRole().equals("Inst")) {
                mv = new ModelAndView("redirect:/");  //redirects to home page for the instructors

            }
        }
        else if (!(u.isPresent())){
            System.out.println("No user");
            //try to handle it
        }

        return mv;

    }

    @RequestMapping(value="/adminView") //this is how we call this method via browser
    public ModelAndView adminView(){
        ModelAndView mv = new ModelAndView("adminpage");
        //mv.getView();
        return mv;
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
