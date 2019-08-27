package com.fatec.ite.Concessionaria.domains.user;

import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.car.CarService;
import com.fatec.ite.Concessionaria.domains.purchase.Purchase;
import com.fatec.ite.Concessionaria.generics.GenericServiceImpl;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserService extends GenericServiceImpl<User>{

	@Autowired
	private CarService carService;

	public User saveFromForm(UserForm userForm) {
        return save(new User(userForm.getFullName(),userForm.getEmail(),userForm.getCpf(),userForm.getYearsOld()));
	}

	public Car addCarToUser(User newUser, Car newCar) {
		newCar.setUserOwner(newUser);
		return carService.save(newCar);
	}

	public void addSaleAndBuy(User salesMan, User buyer, Purchase purchase) {
		salesMan.addSale(purchase);
		buyer.addBuy(purchase);
		repo.saveAll(Arrays.asList(salesMan,buyer));
	}
}