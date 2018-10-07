package ru.otus.dz15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PreviewController {

    @GetMapping("/preview-genres")
    public String testGenresPage(Model model){
//        return "test2";
        return "redirect:/genres";
    }

    @GetMapping("/preview-authors")
    public String testAuthorPage(Model model){
//        return "test2";
        return "redirect:/authors";
    }
}
