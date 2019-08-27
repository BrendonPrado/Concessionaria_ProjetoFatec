package com.fatec.ite.Concessionaria.domains.ad;

import com.fatec.ite.Concessionaria.generics.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AdRepository extends GenericRepository<Ad> {

    List<Ad> findByAdStatus(AdStatus adStatus);

    @Query("from Ad as a where a.price > :preco")
    List<Ad> pegarMaiorQuePreco(double preco);
}
