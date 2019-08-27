package com.fatec.ite.Concessionaria.domains.purchase;

import com.fatec.ite.Concessionaria.domains.ad.Ad;
import com.fatec.ite.Concessionaria.domains.ad.AdService;
import com.fatec.ite.Concessionaria.domains.car.CarService;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.domains.user.UserService;
import com.fatec.ite.Concessionaria.generics.GenericServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService extends GenericServiceImpl<Purchase> {

    @Autowired
    private AdService adService;

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    public Purchase purchaseAd(PurchaseForm purchaseForm) throws ObjectNotFoundException {
        Ad ad = adService.findById(purchaseForm.getAdId());
        User buyer = userService.findById(purchaseForm.getBuyerId());
        Purchase purchase = Purchase.builder().buyer(buyer).saleCar(ad.getCar()).salesMan(ad.getSalesMan()).build();
        //carService.addPurchase(ad.getCar(),purchase);
        adService.setPurchased(ad);
       carService.setNewOwner(buyer,ad.getCar());
       // userService.addSaleAndBuy(ad.getSalesMan(),buyer,purchase);
       Purchase persistedPurchase = save(purchase);
       // System.out.println(persistedPurchase);
        return persistedPurchase;
    }
}
