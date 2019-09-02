package com.fatec.ite.Concessionaria.domains.car;

import com.fatec.ite.Concessionaria.domains.ad.Ad;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping
    private ResponseEntity<Void> save(@RequestBody CarForm newCar) throws ObjectNotFoundException {
        Car car = service.savefromForm(newCar);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/cars/"+car.getId()).buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Car> find(@PathVariable Integer id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
