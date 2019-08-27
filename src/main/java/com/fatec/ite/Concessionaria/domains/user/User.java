package com.fatec.ite.Concessionaria.domains.user;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatec.ite.Concessionaria.domains.ad.Ad;
import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.purchase.Purchase;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String fullName;

    @NonNull
    private String email;

    @NonNull
    private String cpf;

    @NonNull
    private Integer yearsOld;

    @JsonIgnore
    @OneToMany(mappedBy = "userOwner",fetch = FetchType.LAZY)
    private List<Car> userCars = new ArrayList<Car>();

    @JsonIgnore
    @OneToMany(mappedBy = "salesMan", fetch = FetchType.LAZY,orphanRemoval = false)
    private List<Purchase> sales = new ArrayList<Purchase>();

    @JsonIgnore
    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY,orphanRemoval = false)
    private List<Purchase> purchases = new ArrayList<Purchase>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "salesMan",fetch = FetchType.LAZY)
    private List<Ad> userAds = new ArrayList<Ad>();

    public void addCarUser(Car newCar){
        userCars.add(newCar);
    }

    public void addBuy(Purchase purchase) {
        purchases.add(purchase);
    }

    public void addSale(Purchase purchase) {
        sales.add(purchase);
    }
}