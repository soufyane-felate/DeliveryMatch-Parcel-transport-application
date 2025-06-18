package com.DeliveryMatch.DeliveryMatch.Repository;

import com.DeliveryMatch.DeliveryMatch.Model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByTrajetConducteurId(Long conducteurId);
}
