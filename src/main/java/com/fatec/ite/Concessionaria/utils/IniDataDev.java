package com.fatec.ite.Concessionaria.utils;


import com.fatec.ite.Concessionaria.domains.ad.Ad;
import com.fatec.ite.Concessionaria.domains.ad.AdForm;
import com.fatec.ite.Concessionaria.domains.ad.AdService;
import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.purchase.PurchaseForm;
import com.fatec.ite.Concessionaria.domains.purchase.PurchaseService;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.domains.user.UserForm;
import com.fatec.ite.Concessionaria.domains.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class IniDataDev {
    @Autowired
    private UserService userService;

    @Autowired
    private AdService adService;

    @Autowired
    private PurchaseService purchaseService;

    public void initializeDataDev() throws ObjectNotFoundException {
        UserForm userForm = new UserForm("Brendon Prado", "brendon.prado@fatec.sp.gov.br", "28892992", 20);
        User newUser = userService.saveFromForm(userForm);

        Car newCar = new Car("Fiat","Uno","788-hajj",2010);
        Car car2 = new Car("Honda","City","889-ndii",2012);
        Car persistedCar = userService.addCarToUser(newUser, newCar);

        Ad ad = adService.saveFromForm(new AdForm(newUser.getId(),persistedCar.getId(),20000));
        User buyer = userService.saveFromForm(new UserForm("Batata Maranhão", "bandhisdjsda.nsdnasddo@fatec.sp.gov.br", "81291898", 20));
        
        Car persistedCar0 = userService.addCarToUser(buyer, car2);
        adService.saveFromForm(new AdForm(buyer.getId(),persistedCar0.getId(),35000));


        purchaseService.purchaseAd(new PurchaseForm(buyer.getId(),ad.getId()));
    }
}
