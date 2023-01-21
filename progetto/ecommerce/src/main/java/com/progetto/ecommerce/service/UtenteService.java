package com.progetto.ecommerce.service;

import com.progetto.ecommerce.model.Utente;
import com.progetto.ecommerce.repo.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    private UserRepo userRepo;
    @Autowired
    public UtenteService(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    public Utente salvaUtente(Utente utente){
        return userRepo.save(utente);
    }
    public String utentePresente (Utente utente){
        Utente utente1 = userRepo.findByUserId(utente.getUserId());
        return utente1!=null ? utente1.getUserId():null;
    }
}
