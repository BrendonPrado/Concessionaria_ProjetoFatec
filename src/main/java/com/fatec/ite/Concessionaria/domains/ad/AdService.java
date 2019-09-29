package com.fatec.ite.Concessionaria.domains.ad;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.car.CarService;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.domains.user.UserService;
import com.fatec.ite.Concessionaria.generics.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AdService extends GenericServiceImpl<Ad> {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    public Ad saveFromForm(AdForm adForm) throws ObjectNotFoundException {
        Car car = carService.findById(adForm.getCarId());
        User seller = userService.findById(adForm.getSalesManId());
        if(existsByCar(car) && !carService.sellerIsTheOwnerOfCar(car,seller))
            throw new DataIntegrityViolationException("Este carro já possui um anuncio de venda, ou não é seu para anunciar");
        Ad newAd = new Ad(null,seller,car,adForm.getPrice(),AdStatus.Available,new Date());
        Ad persisted = save(newAd);
        return persisted;
    }

    public void setSold(Ad ad){
        ad.setAdStatus(AdStatus.Sold);
        save(ad);
    }

    public List<Ad> findByStatus(AdStatus adStatus){
        return ((AdRepository) this.repo).findByAdStatus(adStatus);
    }

    public List<Ad> findByPriceHigh(double price){
        return ((AdRepository) this.repo).pegarMaiorPrecoQue(price);
    }

	public List<Ad> findAllLikeModelAndBrand(Optional<String> model,Optional<String> brand) {
        if(model.isPresent() || brand.isPresent())
		    return ((AdRepository)this.repo).findLikeModelOrBrand(model.orElse(null), brand.orElse(null));
        return this.repo.findAll();
    }

    public boolean existsByCar(Car car){
        return ((AdRepository)this.repo).existsByCar(car);
    }
}
