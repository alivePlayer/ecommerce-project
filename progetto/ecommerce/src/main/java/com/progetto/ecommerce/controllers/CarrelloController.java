package com.progetto.ecommerce.controllers;
import com.progetto.ecommerce.DTO.OrderDTO;
import com.progetto.ecommerce.DTO.ResponseOrdineDTO;
import com.progetto.ecommerce.model.Oggetti;
import com.progetto.ecommerce.model.Ordine;
import com.progetto.ecommerce.model.Utente;
import com.progetto.ecommerce.repo.OrdineRepo;
import com.progetto.ecommerce.repo.UserRepo;
import com.progetto.ecommerce.service.OggettiService;
import com.progetto.ecommerce.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class CarrelloController {

    @Autowired
    private OrdineService ordineService;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrdineRepo ordineRepo;

    @GetMapping("/tuttiIProdotti")
    public ResponseEntity<List<Oggetti>> getTuttiIProdotti(Utente utenteInviato){
        OrderDTO dto=ordineRepo.findById(utenteInviato.getUserId());
        List<Oggetti>oggettiPresenti=dto.getOggettiNelCarrello();
        return ResponseEntity.ok(oggettiPresenti);
    }

    @PutMapping("/aggiungiAlCarrello")
    public ResponseEntity<List<Oggetti>> aggiungiAlCarrello(Utente utenteInviato, Oggetti oggetto){
        OrderDTO dto=ordineRepo.findById(utenteInviato.getUserId());
        List<Oggetti> oggettiList=dto.getOggettiNelCarrello();
        oggettiList.add(oggetto);
        return ResponseEntity.ok(oggettiList);
    }



    @GetMapping("/ordini/{idOrdine}")
    public ResponseEntity<Ordine> getDettagliOrdine(Long idOrdine){
        Ordine ordine=ordineService.getDettagliOrdine(idOrdine);
        return ResponseEntity.ok(ordine);
    }

    @RequestMapping(path = "/inserisciOrdine")
    public ResponseEntity<?> ordina(@RequestBody OrderDTO orderDTO) {
        ResponseOrdineDTO responseOrdineDTO = new ResponseOrdineDTO();

        System.out.println(orderDTO.getEmail());
        float costo = ordineService.getValoreCarrello(orderDTO.getOggettiNelCarrello());
        Optional<Utente> utentePresente= Optional.ofNullable(userRepo.findByUserId(orderDTO.getEmail()));
        System.out.println(utentePresente.isPresent());
        if (utentePresente.isPresent()) {

            Utente utente=utentePresente.get();
            System.out.println(utente.getHaLoggato());

            if (utente.getHaLoggato()) {
                Ordine ordine = new Ordine(orderDTO.getOggettiNelCarrello(), utente);
                ordineService.salvaOrdine(ordine);
                responseOrdineDTO.setPrezzoFinale(costo);
                responseOrdineDTO.setDate(String.valueOf(LocalDateTime.now()));
                responseOrdineDTO.setInvoiceNumber(new Random().nextInt(1000));
                responseOrdineDTO.setOrderId((long) ordine.getId());
                System.out.println(responseOrdineDTO);
                return ResponseEntity.ok(responseOrdineDTO);
            }
        }

            return ResponseEntity.internalServerError().build();

        }



}
