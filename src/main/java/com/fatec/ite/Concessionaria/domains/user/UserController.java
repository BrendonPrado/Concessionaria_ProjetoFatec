package com.fatec.ite.Concessionaria.domains.user;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody UserForm userForm){
        User newUser = service.saveFromForm(userForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/users/"+newUser.getId()).buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<User> find(@PathVariable Integer id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(service.findById(id));
    }
}