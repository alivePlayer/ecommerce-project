package com.progetto.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="utenti")
@AllArgsConstructor
@Data
public class Utente {

    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false)
    private String indirizzo;

    @Column
    private String numeroTelefono;

    @Column
    private boolean haLoggato;



    public Utente(){}
    public Utente(String userId){
        this.userId=userId;
    }

    public boolean getHaLoggato() {
        return haLoggato;
    }

    public void setHaLoggato(boolean haLoggato) {
        this.haLoggato = haLoggato;
    }





    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public boolean isHaLoggato() {
        return haLoggato;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
