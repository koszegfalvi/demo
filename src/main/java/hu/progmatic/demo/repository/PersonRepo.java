package hu.progmatic.demo.repository;

import hu.progmatic.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {

}

