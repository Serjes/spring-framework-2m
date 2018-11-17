package ru.otus.dz17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexPage(Model model) {
        return "index";
    }

    @GetMapping("/preview-genres")
    public String testGenresPage(Model model){
        return "redirect:/genres-table";
    }

    @GetMapping("/preview-authors")
    public String testAuthorPage(Model model){
        return "redirect:/authors-table";
    }
}
