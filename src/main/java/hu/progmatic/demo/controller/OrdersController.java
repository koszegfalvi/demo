package hu.progmatic.demo.controller;

import hu.progmatic.demo.model.Orders;
import hu.progmatic.demo.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/orders")
public class OrdersController {
    private EntityService entityService;

    @GetMapping("/new/{person_id}")
    public  String createOrders(Model model, @PathVariable("person_id")Integer personId){
        model.addAttribute("personId",personId);
        model.addAttribute("orders", new Orders());

        return "orders_form";
    }
    @PostMapping("/add")
    public  String createOrders(@ModelAttribute("orders")Orders orders, @PathVariable("person_id")Integer personId){
        orders.setOwner(entityService.getPersonById(personId));
        entityService.saveOrders(orders);
        return  "redirect:/home";
    }


}
