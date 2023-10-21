package hu.progmatic.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   private String name;
   private String birthPlace;
   private Date birthDate;
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonManagedReference
    private Set<Orders> ordersList;




}
