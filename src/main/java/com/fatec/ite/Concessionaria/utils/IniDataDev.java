package com.fatec.ite.Concessionaria.utils;


import com.fatec.ite.Concessionaria.domains.ad.Ad;
import com.fatec.ite.Concessionaria.domains.ad.AdForm;
import com.fatec.ite.Concessionaria.domains.ad.AdService;
import com.fatec.ite.Concessionaria.domains.ad.AdStatus;
import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.car.CarRepository;
import com.fatec.ite.Concessionaria.domains.purchase.Purchase;
import com.fatec.ite.Concessionaria.domains.purchase.PurchaseForm;
import com.fatec.ite.Concessionaria.domains.purchase.PurchaseRepository;
import com.fatec.ite.Concessionaria.domains.purchase.PurchaseService;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.domains.user.UserForm;
import com.fatec.ite.Concessionaria.domains.user.UserRepository;
import com.fatec.ite.Concessionaria.domains.user.UserService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IniDataDev {
    @Autowired
    private UserService userService;

    @Autowired
    private AdService adService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;
    public void initializeDataDev() throws ObjectNotFoundException {
        UserForm userForm = new UserForm("Brendon Prado", "brendon.prado@fatec.sp.gov.br", "28892992", 20);
        User newUser = userService.saveFromForm(userForm);

        Car newCar = new Car("Fiat","Uno","788-hajj",2010);
        Car persistedCar = userService.addCarToUser(newUser, newCar);

        Ad ad = adService.saveFromForm(new AdForm(newUser.getId(),persistedCar.getId(),20000));
        User buyer = userService.saveFromForm(new UserForm("Batata Maranhão", "bandhisdjsda.nsdnasddo@fatec.sp.gov.br", "81291898", 20));
        purchaseService.purchaseAd(new PurchaseForm(buyer.getId(),ad.getId()));

        System.out.println(adService.findByStatus(AdStatus.Sold));
        System.out.println(adService.findByPriceHigh(500).get(0).getCar().getModel());

        System.out.println(carRepository.findByCarsAd(ad).get(0).getBrand());
        System.out.println(purchaseRepository.findBySaleCar(persistedCar).get(0).getBuyer().getFullName());
        System.out.println(userRepository.findByFullNameContaining("Brendo").get(0).getFullName());
    }
}
