package com.DeliveryMatch.DeliveryMatch.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class DemandTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String dimensions;
    private double poids;
    private String type;
    @ManyToOne
    @JoinColumn(name = "expediteur_id")
    private User expediteur;
    @ManyToOne
    @JoinColumn(name = "trajet_id")
    private Trajet trajet;
}
