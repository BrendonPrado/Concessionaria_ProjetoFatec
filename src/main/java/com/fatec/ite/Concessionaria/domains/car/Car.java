package com.fatec.ite.Concessionaria.domains.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatec.ite.Concessionaria.domains.ad.Ad;
import com.fatec.ite.Concessionaria.domains.purchase.Purchase;
import com.fatec.ite.Concessionaria.domains.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    @NonNull
    private String brand;
    @NonNull
    private String model;

    @NonNull
    private String plate;

    @NonNull
    private Integer yearOfFabrication;

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

