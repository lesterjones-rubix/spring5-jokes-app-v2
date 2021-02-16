package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    //We want to bring in the joke service
    private final JokeService jokeService;

    @Autowired //We can omit this @autowired because we only have one service
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model){

        model.addAttribute("joke", jokeService.getJoke());

        //We return the String index which is going to tell the Spring
        // MVC that we want to do the index view
        return "index";
    }

}
