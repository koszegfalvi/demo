package hu.progmatic.demo.controller;

import hu.progmatic.demo.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PageController {
    private EntityService entityService;

    @GetMapping({"","/","/home"})
    public String getHome(Model model){
        model.addAttribute("persons", entityService.getAllPerson());
        return "home";
    }
}
