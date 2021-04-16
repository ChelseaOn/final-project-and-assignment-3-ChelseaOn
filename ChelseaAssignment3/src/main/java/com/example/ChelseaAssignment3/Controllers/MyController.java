package com.example.ChelseaAssignment3.Controllers;
import com.example.ChelseaAssignment3.Models.Movies;
import com.example.ChelseaAssignment3.Models.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Optional;




@Controller
public class MyController {

    @Bean
    public ViewResolver myViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver =
                new InternalResourceViewResolver();
        internalResourceViewResolver.setSuffix(".jsp");
        // .. further setup
        return internalResourceViewResolver;

    }




    @Autowired
    MoviesRepo mRepo;

    @RequestMapping("/new")
    public ModelAndView new() {
        ModelAndView mv = new ModelAndView("new");
        mv.addObject("movies", mRepo.findAll());
        return mv;
    }

    @RequestMapping("/new2")
    public ModelAndView new2() {
        ModelAndView mv = new ModelAndView("new2");
        mv.addObject("movies", mRepo.findAll());
        return mv;
    }

    @RequestMapping("/")
    public String home() {
        return "index";

}

    @RequestMapping(value="/edit/{movieID}", method= RequestMethod.GET)
    public ModelAndView edit(@PathVariable("movieID") int movieID){
        ModelAndView mv = new ModelAndView("edit");
        Movies sToEdit;
        Optional<Movies> m = mRepo.findById(movieID);
        sToEdit = m.get();
        mv.addObject("selectedMovies", sToEdit);
        return mv;
    }
    @RequestMapping(value="save", method=RequestMethod.POST)
    public ModelAndView save(@RequestParam("movieID") int movieID,
                             @RequestParam("name") String name,
                             @RequestParam("release_year") String release_year,
                             @RequestParam("rating") String rating,
                             @RequestParam("genre") String genre,
                             @RequestParam("description") String description)


    {
        ModelAndView mv = new ModelAndView("redirect:/new");
        Movies sToSave;
        Optional<Movies> s = mRepo.findById(movieID);
        if (s.isPresent()){
            sToSave = s.get();
        }
        else{
            sToSave = new Movies();
            sToSave.setMovieID(movieID);
        }
        sToSave.setFname(fname);
        sToSave.setLname(lname);
        mRepo.save(sToSave);
        mv.addObject("movies", mRepo.findAll());
        return mv;
    }

}
