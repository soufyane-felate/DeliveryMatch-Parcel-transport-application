package com.DeliveryMatch.DeliveryMatch.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lieuDepart;

    private String destination;

    @ElementCollection
    @CollectionTable(name = "etapes_intermediaires", joinColumns = @JoinColumn(name = "trajet_id"))
    @Column(name = "etape")
    private List<String> etapes = new ArrayList<>();

    private String typeMarchandise;

    private double capaciteDisponible;

    @Embedded
    private Dimensions dimensionsMax;

    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    @OneToMany(mappedBy = "trajet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Demande> demandes = new ArrayList<>();

}

