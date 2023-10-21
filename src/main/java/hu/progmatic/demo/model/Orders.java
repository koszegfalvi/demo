package hu.progmatic.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "place")
    private  String where;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "people_id")
    @JsonBackReference
    private Person owner;
}
