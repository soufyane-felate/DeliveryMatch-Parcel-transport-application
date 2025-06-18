package com.DeliveryMatch.DeliveryMatch.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Expediteur extends User {

    public Expediteur() {
        this.setRole(Role.EXPEDITEUR);
    }
    @OneToMany
    private List<Demande> demandes;
}
