package com.fatec.ite.Concessionaria.domains.user;

import com.fatec.ite.Concessionaria.generics.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends GenericRepository<User>{

    List<User> findByFullNameContaining(String name);

    @Query("from User as u where u.cpf = :cpf")
    User findByCpf(String cpf);
}