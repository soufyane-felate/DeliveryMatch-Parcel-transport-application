package com.DeliveryMatch.DeliveryMatch.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Conducteur extends User {

    public Conducteur() {
        this.setRole(Role.CONDUCTEUR);
    }
    @OneToMany(mappedBy = "conducteur"  , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Trajet> trajets;
}
