package com.progetto.ecommerce.controllers;

import com.progetto.ecommerce.model.Oggetti;
import com.progetto.ecommerce.service.OggettiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oggetti")

public class OggettiResource {
    private final OggettiService oggettiService;

    public OggettiResource(OggettiService oggettiService) {
        this.oggettiService = oggettiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Oggetti>> getAllOggetti(){
        List<Oggetti> oggetti = oggettiService.trovaTuttiGliOggetti();
        return new ResponseEntity<>(oggetti, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Oggetti> getOggettiById(@PathVariable("id")Long id){
        Oggetti oggetto = oggettiService.findOggettiById(id);
        return new ResponseEntity<>(oggetto,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Oggetti> addOggetto(@RequestBody Oggetti oggetto){
        Oggetti newOggetto = oggettiService.aggiungiOggetto(oggetto);
        return new ResponseEntity<>(newOggetto, HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Oggetti> updateOggetto(@RequestBody Oggetti oggetto){
        Oggetti updateOggetto =  oggettiService.aggiungiOggetto(oggetto);
        return new ResponseEntity<>(updateOggetto, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteOggetto(@PathVariable("id")Long id){
        oggettiService.eliminaOggetti(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
