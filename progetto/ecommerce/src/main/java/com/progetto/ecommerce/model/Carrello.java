package com.progetto.ecommerce.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="carrello")
public class Carrello{
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private int quantita;
    private float prezzo;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}
