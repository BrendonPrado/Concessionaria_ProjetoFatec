package com.fatec.ite.Concessionaria.domains.ad;

import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.user.User;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    private User salesMan;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    private Car car;

    private double price;

    @Enumerated(EnumType.STRING)
    private AdStatus adStatus;
}
