package edu.unimag.taller01.modelos;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "pickup_at", nullable = false)
    private  java.time.OffsetDateTime pickupAt;
    @Column(name = "return_at")
    private  java.time.OffsetDateTime returnAt;
    @Column(name = "total_price", precision = 12, scale = 2)
    private  java.math.BigDecimal total_price;
    private  String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
