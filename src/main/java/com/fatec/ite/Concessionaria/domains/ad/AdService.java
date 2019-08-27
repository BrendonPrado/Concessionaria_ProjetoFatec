package com.fatec.ite.Concessionaria.domains.ad;

import com.fatec.ite.Concessionaria.domains.car.CarService;
import com.fatec.ite.Concessionaria.domains.purchase.Purchase;
import com.fatec.ite.Concessionaria.domains.purchase.PurchaseForm;
import com.fatec.ite.Concessionaria.domains.purchase.PurchaseService;
import com.fatec.ite.Concessionaria.domains.user.UserService;
import com.fatec.ite.Concessionaria.generics.GenericServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService extends GenericServiceImpl<Ad> {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    public Ad saveFromForm(AdForm adForm) throws ObjectNotFoundException {
        Ad newAd = new Ad(null,userService.findById(adForm.getSalesManId()),carService.findById(adForm.getCarId()),adForm.getPrice(),AdStatus.Available);
        Ad persisted = save(newAd);
        return persisted;
    }

    public void setPurchased(Ad ad){
        ad.setAdStatus(AdStatus.Sold);
        save(ad);
    }

    public List<Ad> findByStatus(AdStatus adStatus){
        return ((AdRepository) this.repo).findByAdStatus(adStatus);
    }

    public List<Ad> findByPriceHigh(double price){
        return ((AdRepository) this.repo).pegarMaiorQuePreco(price);
    }


}
