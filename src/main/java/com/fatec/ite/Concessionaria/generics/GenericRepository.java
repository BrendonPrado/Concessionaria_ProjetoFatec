package com.fatec.ite.Concessionaria.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract interface GenericRepository<T> extends JpaRepository<T, Integer>  {

}