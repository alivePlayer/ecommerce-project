package com.progetto.ecommerce.repo;

import com.progetto.ecommerce.DTO.OrderDTO;
import com.progetto.ecommerce.model.Oggetti;
import com.progetto.ecommerce.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepo extends JpaRepository<Ordine,Long> {

    OrderDTO findById(String userId);
}
