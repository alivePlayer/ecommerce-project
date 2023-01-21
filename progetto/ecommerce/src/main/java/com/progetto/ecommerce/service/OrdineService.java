package com.progetto.ecommerce.service;

import com.progetto.ecommerce.model.Oggetti;
import com.progetto.ecommerce.model.Ordine;
import com.progetto.ecommerce.repo.OggettiRepo;
import com.progetto.ecommerce.repo.OrdineRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrdineService{

    private OggettiRepo oggettiRepo;
    private OrdineRepo ordineRepo;
    public OrdineService(OggettiRepo oggettiRepo, OrdineRepo ordineRepo){
        this.ordineRepo=ordineRepo;
        this.oggettiRepo=oggettiRepo;
    }
    public Ordine getDettagliOrdine(Long idOrdine){
        Optional<Ordine> ordine=this.ordineRepo.findById(idOrdine);
        return ordine.isPresent()?ordine.get():null;
    }



    public float getValoreCarrello(List<Oggetti> oggettiList){
        float carrelloTotale=0f;
        float carreloSingoloOggetto=0f;
        List<Oggetti> oggettiVisti= new ArrayList<>();
        int i =0;
        for (Oggetti oggetti : oggettiList){
            Long idOggetto = oggetti.getId();
            Optional<Oggetti> oggetto = oggettiRepo.findById(idOggetto);

            if(oggetto.isPresent() && !(oggettiVisti.contains(oggetto))){
                oggettiVisti.add(oggetti);

                Oggetti oggetto1 =oggetto.get();

                if(oggetto1.getQuantita()>=oggetti.getQuantita()){

                    carreloSingoloOggetto=oggetto1.getPrezzo()*oggettiList.get(i).getQuantita();

                    oggetto1.setQuantita(oggetto1.getQuantita()-oggetti.getQuantita());

                }else {


                    carreloSingoloOggetto = oggetti.getQuantita() * oggetti.getPrezzo();


                    oggetto1.setQuantita(200);
                }

                carrelloTotale=carrelloTotale+carreloSingoloOggetto;
                i++;






            }

        }

        return carrelloTotale;

    }



    public Ordine salvaOrdine(Ordine ordine){
        return ordineRepo.save(ordine);
    }


}
