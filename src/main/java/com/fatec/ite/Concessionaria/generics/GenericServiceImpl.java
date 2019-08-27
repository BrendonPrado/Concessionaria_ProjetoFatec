package com.fatec.ite.Concessionaria.generics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import javassist.tools.rmi.ObjectNotFoundException;

public class GenericServiceImpl<T> implements GenericService<T> {

    @Autowired
    protected GenericRepository<T> repo;

    @Override
    public T save(T entity) {
		try {
            return repo.save(entity);
        } catch (Exception e) {
            throw new DataIntegrityViolationException("não foi possível está operação" + entity.getClass());
        }
    }

    @Override
    public T findById(Integer id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi possível buscar esse objeto"));
    }

    @Override
    public void deleteById(Integer id) throws ObjectNotFoundException {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new ObjectNotFoundException("não foi possível está operação");
        }
    }

    @Override
    public List<T> findAll() {
        return repo.findAll();
    }

}