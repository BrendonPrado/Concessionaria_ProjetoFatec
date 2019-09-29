package com.fatec.ite.Concessionaria.domains.purchase;

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
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @PostMapping(value = "/ad/{id}")
    public ResponseEntity<Void> purchase(@PathVariable Integer id, @RequestBody PurchaseForm purchaseForm) throws ObjectNotFoundException {
        Purchase purchase = service.purchaseAd(purchaseForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/ads/"+purchase.getId()).buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Purchase> find(@PathVariable Integer id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(service.findById(id));
    }


}
