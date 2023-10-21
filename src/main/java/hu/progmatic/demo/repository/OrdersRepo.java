package hu.progmatic.demo.repository;

import hu.progmatic.demo.model.Orders;
import hu.progmatic.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  OrdersRepo extends JpaRepository<Orders,Integer> {

    List<Orders> getOrdersByOwner(Person person);

    Integer deleteAllByOwner(Person person);



}
