package edu.unimag.taller01.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String plate;


    @Column(nullable = false)
    private  String brand;

    @Column(nullable = false)
    private  String model;

    @Column(nullable = false)
    private  Integer year;
    @Column(nullable = false)
    private  String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station station;

    @OneToMany(mappedBy = "vehicle")
    private Set<Reservation>  reservations;
}
