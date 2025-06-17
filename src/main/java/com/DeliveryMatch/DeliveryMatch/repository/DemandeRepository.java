package com.DeliveryMatch.DeliveryMatch.repository;

import com.DeliveryMatch.DeliveryMatch.entities.DemandTransport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<DemandTransport, Long> {
}
