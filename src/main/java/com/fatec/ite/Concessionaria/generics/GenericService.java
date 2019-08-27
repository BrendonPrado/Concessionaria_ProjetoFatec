package com.fatec.ite.Concessionaria.generics;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

public interface GenericService<T> {

    T save(T entity);

    T findById(Integer id) throws ObjectNotFoundException;

    void deleteById(Integer id) throws ObjectNotFoundException;

    List<T> findAll();
}