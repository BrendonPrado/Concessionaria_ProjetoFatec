package com.fatec.ite.Concessionaria.domains.ad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.views.View;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ad {

    @JsonView(View.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    private User salesMan;

    @JsonView(View.Public.class)
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    private Car car;

    @JsonView(View.Public.class)
    @Column(nullable = false)
    private double price;

    @JsonView(View.Public.class)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AdStatus adStatus;

    @JsonFormat(pattern = "yyyy/mm/dd HH:MM")
    @JsonView(View.Public.class)
    private Date adDate;
}
