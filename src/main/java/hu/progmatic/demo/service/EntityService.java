package hu.progmatic.demo.service;

import hu.progmatic.demo.model.Orders;
import hu.progmatic.demo.model.Person;
import hu.progmatic.demo.repository.OrdersRepo;
import hu.progmatic.demo.repository.PersonRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityService {
    private PersonRepo personRepo;
    private OrdersRepo ordersRepo;

    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }
    public List<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }
    public Person getPersonById(Integer id) {
        return personRepo.findById(id).orElse(null);
    }
    public List<Orders> getAllOrdersByPerson(Person person) {
        return ordersRepo.getOrdersByOwner(person);
    }
    public void savePerson(Person person) {
        personRepo.save(person);
    }
    public void saveOrders(Orders orders) {
        ordersRepo.save(orders);
    }
    public void updatePerson(Person person) {
        personRepo.save(person);
    }
    @Transactional
    public void deletePersonById(Integer id) {
        personRepo.deleteById(id);
    }

    @Transactional
    public void deleteOrdersByPerson(Person person) {
        ordersRepo.deleteAllByOwner(person);
    }
}
