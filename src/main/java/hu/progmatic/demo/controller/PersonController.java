package hu.progmatic.demo.controller;

import hu.progmatic.demo.model.Person;
import hu.progmatic.demo.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private EntityService entityService;


    @GetMapping("/{id}")
    public String getPersonById(Model model, @PathVariable Integer id) {
        Person person = entityService.getPersonById(id);
        model.addAttribute("expenses", entityService.getAllOrdersByPerson(person));
        model.addAttribute("person", person);
        return "person";
    }
    @GetMapping("/new")
    public String createPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person_form";
    }
    @PostMapping("/add")
    public String createPerson(@ModelAttribute("person") Person person) {
        entityService.savePerson(person);
        return "redirect:/home";
    }
    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer id) {
        entityService.deleteOrdersByPerson(entityService.getPersonById(id));
        entityService.deletePersonById(id);
        return "redirect:/home";
    }
    @GetMapping("/edit/{id}")
    public  String editPerson(Model model, @PathVariable("id") Integer id){
        model.addAttribute("person",entityService.getPersonById(id));
        model.addAttribute("post_url", "/edit/"+ id);
        return "person_form";
    }
    @PostMapping ("/edit/{id}")
    public  String editPerson(@ModelAttribute("person")Person person){
        entityService.updatePerson(person);
        return  "redirect:/person";
    }










}
