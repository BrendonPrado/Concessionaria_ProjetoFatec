package com.fatec.ite.Concessionaria.domains.car;

import com.fatec.ite.Concessionaria.domains.purchase.Purchase;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.domains.user.UserService;
import com.fatec.ite.Concessionaria.generics.GenericServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService extends GenericServiceImpl<Car> {

    @Autowired
    private UserService userService;

    public Car savefromForm(CarForm newCar) throws ObjectNotFoundException {
        Car car = new Car(newCar.getBrand(),newCar.getModel(),newCar.getPlate(),newCar.getYearOfFabrication());
        return userService.addCarToUser(userService.findById(newCar.getUserId()),car);
    }


    public void addPurchase(Car car, Purchase purchase) {
        car.addPurchase(purchase);
        save(car);
    }

    public void setNewOwner(User buyer, Car car) {
        car.setUserOwner(buyer);
        repo.save(car);
    }
}
