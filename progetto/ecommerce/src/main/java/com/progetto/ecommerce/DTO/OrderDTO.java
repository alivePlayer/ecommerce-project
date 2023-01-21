package com.progetto.ecommerce.DTO;

import com.progetto.ecommerce.model.Carrello;
import com.progetto.ecommerce.model.Oggetti;

import java.util.List;

public class OrderDTO {


    private List<Oggetti> oggettiNelCarrello;
    private String email;


    public OrderDTO(){}
    public OrderDTO( List<Oggetti>oggettiNelCarrello, String email){

        this.oggettiNelCarrello=oggettiNelCarrello;
        this.email=email;

    }



    public void setOggettiNelCarrello(List<Oggetti> oggettiNelCarrello) {
        this.oggettiNelCarrello = oggettiNelCarrello;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public List<Oggetti> getOggettiNelCarrello() {
        return oggettiNelCarrello;
    }

    public String getEmail() {
        return email;
    }

}
