package com.progetto.ecommerce.model;

import jakarta.persistence.*;

import javax.management.Descriptor;
import java.io.Serializable;
@Entity
public class Oggetti implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String imageUrl;
    private String objectCode;
    private String descrizione;
    private float prezzo;
    private int quantita;
    public Oggetti(){}
    public Oggetti(String name,String imageUrl,String objectCode,String descrizione, float prezzo,int quantita){
        this.name=name;
        this.imageUrl=imageUrl;
        this.objectCode=objectCode;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
        this.quantita=quantita;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public String getDescrizione() { return descrizione; }
    public float getPrezzo() {
        return prezzo;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }
    public void setDescrizione(String descrizione){
        this.descrizione=descrizione;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
