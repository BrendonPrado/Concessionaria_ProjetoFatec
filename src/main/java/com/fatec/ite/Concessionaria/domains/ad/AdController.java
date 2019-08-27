package com.fatec.ite.Concessionaria.domains.ad;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/ads")
public class AdController {

    @Autowired
    private AdService service;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AdForm adForm) throws ObjectNotFoundException {
        Ad newAd = service.saveFromForm(adForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/ads/"+newAd.getId()).buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Ad> find(@PathVariable Integer id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
