package com.fatec.ite.Concessionaria.domains.purchase;

import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.generics.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends GenericRepository<Purchase> {

    List<Purchase> findByBuyer(User user);

    @Query("from Purchase as p where p.saleCar = :car")
    List<Purchase> findBySaleCar(Car car);
}
