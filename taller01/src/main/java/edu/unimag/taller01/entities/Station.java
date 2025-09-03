package edu.unimag.taller01.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private  String name;
    @Column(nullable = false)
    private  String city;
    @Column(nullable = false)
    private  String address;

    @OneToMany(mappedBy = "station")
    private Set<Vehicle> vehicles;

}
