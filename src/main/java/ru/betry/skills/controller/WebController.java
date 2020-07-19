package ru.betry.skills.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.betry.skills.entity.Language;
import ru.betry.skills.entity.Programmer;

import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new Programmer(1L, "Boris",
                List.of(new Language(1L, "Test", "Test description", null),
                        new Language(2L, "Test1", "Test description1", null)),
                null));
        return "index";
    }

    @GetMapping("/create_developer")
    public String developer() {
        return "developer";
    }

    @GetMapping("/create_language")
    public String language() {
        return "language";
    }

}
