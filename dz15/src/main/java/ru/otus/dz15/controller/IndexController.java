package ru.otus.dz15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.dz15.service.LibraryService;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexPage(Model model) {
        return "index";
    }
}
