package com.DeliveryMatch.DeliveryMatch.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor

@NoArgsConstructor
@Getter @Setter
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    private Expediteur expediteur;

    @ManyToOne
    private Trajet trajet;


}
