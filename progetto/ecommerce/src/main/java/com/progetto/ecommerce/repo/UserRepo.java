package com.progetto.ecommerce.repo;

import com.progetto.ecommerce.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <Utente, String> {

    Utente findByUserId(String userId);
}
