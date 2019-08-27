package com.fatec.ite.Concessionaria.domains.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CarForm {
    private String brand;
    private String model;
    private String plate;
    private Integer yearOfFabrication;
    private Integer userId;
}
