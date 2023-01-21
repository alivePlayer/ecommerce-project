package com.progetto.ecommerce.controllers;

import com.progetto.ecommerce.model.Utente;
import com.progetto.ecommerce.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserControllers {



    @Autowired
    private UserRepo repo;
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody Utente userData) {
        Utente utente=repo.findByUserId(userData.getUserId());
        if (utente.getPassword().equals(userData.getPassword())){
            utente.setHaLoggato(true);
            repo.save(utente);
            return ResponseEntity.ok(utente);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }

    @PostMapping("/logout")
    public ResponseEntity<?> userLogout(@RequestBody Utente userData){
        Utente utente=repo.findByUserId(userData.getUserId());
        utente.setHaLoggato(false);
        repo.save(utente);
        return  ResponseEntity.ok().build();
    }
    @PostMapping("/registrati")
    public ResponseEntity<?> registerUser(@RequestBody Utente userData){
        Utente utente=repo.findByUserId(userData.getUserId());
        if(utente==null) {
            System.out.println("controllore chiamato positivo");
            userData.setHaLoggato(true);
            return ResponseEntity.ok(repo.save(userData));
        }
        System.out.println("controllore chiamato negativo");
        return (ResponseEntity<?>) ResponseEntity.internalServerError();


    }
}
