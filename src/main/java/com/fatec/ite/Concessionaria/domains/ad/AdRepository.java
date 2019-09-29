package com.fatec.ite.Concessionaria.domains.ad;

import java.util.List;

import com.fatec.ite.Concessionaria.domains.car.Car;
import com.fatec.ite.Concessionaria.generics.GenericRepository;

import org.springframework.data.jpa.repository.Query;


public interface AdRepository extends GenericRepository<Ad> {

    List<Ad> findByAdStatus(AdStatus adStatus);

    @Query("select a from Ad as a where a.price > :preco")
    List<Ad> pegarMaiorPrecoQue(double preco);

    @Query("select a from Ad as a join a.car as c where c.model like %:model% or c.brand like %:brand% ")
    List<Ad> findLikeModelOrBrand(String model,String brand);

	boolean existsByCar(Car car);
}
