package com.progetto.ecommerce.service;

import com.progetto.ecommerce.exception.UserNotFoundException;
import com.progetto.ecommerce.model.Oggetti;
import com.progetto.ecommerce.repo.OggettiRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OggettiService {
    private final OggettiRepo oggettiRepo;
    @Autowired
    public OggettiService (OggettiRepo oggettiRepo){
        this.oggettiRepo=oggettiRepo;
    }

    public Oggetti aggiungiOggetto(Oggetti oggetti){
        oggetti.setObjectCode(UUID.randomUUID().toString());
        return oggettiRepo.save(oggetti);
    }

    public List<Oggetti> trovaTuttiGliOggetti(){
        return oggettiRepo.findAll();
    }

    public Oggetti aggiornaOggetti(Oggetti oggetto){
        return oggettiRepo.save(oggetto);
    }

    public Oggetti findOggettiById(Long id){
        return oggettiRepo.findOggettiById(id)
                .orElseThrow(()->new UserNotFoundException("l'oggetto con id "+id + " non è stato trovato"));
    }

    public void eliminaOggetti (Long id){
        oggettiRepo.deleteOggettiById(id);
    }

}
