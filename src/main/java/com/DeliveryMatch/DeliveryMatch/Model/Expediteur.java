package com.DeliveryMatch.DeliveryMatch.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Expediteur extends User {
    @OneToMany
    private List<Demande> demandes;

    public Expediteur() {
        this.setRole(Role.EXPEDITEUR);
    }
}