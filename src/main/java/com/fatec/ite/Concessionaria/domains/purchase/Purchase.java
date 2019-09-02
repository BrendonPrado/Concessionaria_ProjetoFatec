package com.fatec.ite.Concessionaria.domains.purchase;

import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Purchase {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private User salesMan;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    private User buyer;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    private Car saleCar;
}
