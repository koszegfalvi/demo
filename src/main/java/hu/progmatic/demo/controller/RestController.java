package hu.progmatic.demo.controller;

import hu.progmatic.demo.model.Person;
import hu.progmatic.demo.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class RestController {
    private EntityService entityService;


    @GetMapping("/persons")
    public List<Person> getAllPerson(){
        return entityService.getAllPerson();

    }


}
