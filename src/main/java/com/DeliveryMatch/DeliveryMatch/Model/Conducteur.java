package com.DeliveryMatch.DeliveryMatch.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Conducteur extends User {
    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trajet> trajets;

    public Conducteur() {
        this.setRole(Role.CONDUCTEUR);
    }
}