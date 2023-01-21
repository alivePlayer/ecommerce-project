package com.progetto.ecommerce.repo;

import com.progetto.ecommerce.model.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrelloRepo extends JpaRepository<Carrello,Integer> {

    

}