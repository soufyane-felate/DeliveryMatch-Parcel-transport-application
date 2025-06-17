package com.DeliveryMatch.DeliveryMatch.entities;

import com.DeliveryMatch.DeliveryMatch.enums.StatutDemande;
import jakarta.persistence.*;

@Entity
public class Demande {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatutDemande statut;

    @ManyToOne
    private Expediteur expediteur;

    @ManyToOne
    private Trajet trajet;

    @Embedded
    private Colis colis;

}
