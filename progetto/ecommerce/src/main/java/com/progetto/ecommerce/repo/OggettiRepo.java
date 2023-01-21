package com.progetto.ecommerce.repo;

import com.progetto.ecommerce.model.Oggetti;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OggettiRepo extends JpaRepository<Oggetti,Long> {
    void deleteOggettiById(Long id);

    Optional<Oggetti> findOggettiById(Long id);
}
