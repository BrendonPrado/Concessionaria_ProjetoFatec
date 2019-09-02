package com.fatec.ite.Concessionaria.domains.car;

import com.fatec.ite.Concessionaria.domains.ad.Ad;
import com.fatec.ite.Concessionaria.domains.user.User;
import com.fatec.ite.Concessionaria.generics.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends GenericRepository<Car> {

    List<Car> findByUserOwner(User user);

    @Query("from Car as c where :ad member of c.carsAd")
    List<Car> findByCarsAd(Ad ad);
}
