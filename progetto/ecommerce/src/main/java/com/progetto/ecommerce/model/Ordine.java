package com.progetto.ecommerce.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ordine")
public class Ordine {
    @Id
    @GeneratedValue
    private int id;


    @OneToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @OneToMany
    @JoinColumn(name = "id_ordine")
    private List<Oggetti> oggettiNelCarrello;

    public Ordine(){}
    public Ordine(List<Oggetti> oggettiNelCarrello, Utente utente) {
        this.oggettiNelCarrello=oggettiNelCarrello;
        this.utente=utente;
    }
    public Ordine(Utente utente, List<Oggetti> oggettiNelCarrello){
        this.oggettiNelCarrello=oggettiNelCarrello;
        this.utente=utente;
    }

    public int getId() {
        return id;
    }



    public Utente getUtente() {
        return utente;
    }

    public List<Oggetti> getOggettiNelCarrello() {
        return oggettiNelCarrello;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setOggettiNelCarrello(List<Oggetti> oggettiNelCarrello) {
        this.oggettiNelCarrello = oggettiNelCarrello;
    }
}
