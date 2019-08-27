package com.fatec.ite.Concessionaria.domains.ad;

import com.fatec.ite.Concessionaria.domains.car.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdForm {
    private Integer salesManId;
    private Integer carId;
    private double price;
}
