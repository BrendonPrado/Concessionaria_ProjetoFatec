package com.fatec.ite.Concessionaria.domains.ad;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.ite.Concessionaria.views.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @JsonView(View.Public.class)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Ad> find(@PathVariable Integer id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping()
    @JsonView(View.Public.class)
    public ResponseEntity<List<Ad>> findAll(@RequestParam(name="model", required =false) Optional<String> model,
    @RequestParam(name="brand",required = false) Optional<String> brand){
        return ResponseEntity.ok().body(service.findAllLikeModelAndBrand(model, brand));
    }
}
