package com.fatec.ite.Concessionaria.domains.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.ite.Concessionaria.domains.ad.Ad;
import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.purchase.Purchase;
import com.fatec.ite.Concessionaria.views.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(View.Public.class)
    @NonNull
    private String fullName;

    @JsonView(View.Private.class)
    @NonNull
    @Column(nullable = false,unique = true)
    private String email;

    @JsonView(View.Private.class)
    @NonNull
    @Column(unique = true)
    private String cpf;

    @JsonView(View.Private.class)
    @NonNull
    private Integer yearsOld;

    @JsonView(View.Private.class)
    @JsonIgnore
    @OneToMany(mappedBy = "userOwner",fetch = FetchType.LAZY)
    private List<Car> userCars = new ArrayList<Car>();

    @JsonView(View.Private.class)
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