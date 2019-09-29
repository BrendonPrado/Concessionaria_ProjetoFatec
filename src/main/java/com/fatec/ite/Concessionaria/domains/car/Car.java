package com.fatec.ite.Concessionaria.domains.car;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.ite.Concessionaria.domains.ad.Ad;
import com.fatec.ite.Concessionaria.domains.purchase.Purchase;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.views.View;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(View.Public.class)
    @NonNull
    private String brand;

    @JsonView(View.Public.class)
    @NonNull
    private String model;

    @JsonView(View.Public.class)
    @NonNull
    @Column(unique = true,nullable = false)
    private String plate;

    @JsonView(View.Public.class)
    @NonNull
    private Integer yearOfFabrication;

    @JsonView(View.Public.class)
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_owner_id")
    private User userOwner;

    @JsonIgnore
    @OneToMany(mappedBy = "saleCar", fetch = FetchType.LAZY)
    private List<Purchase> historyPurchase = new ArrayList<Purchase>();

    @JsonIgnore
    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<Ad> carsAd = new ArrayList<Ad>();

    public void addPurchase(Purchase purchase) {
        historyPurchase.add(purchase);
    }
}

