package com.DeliveryMatch.DeliveryMatch.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("CONDUCTEUR")
public class Conducteur extends User {

    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    private List<Trajet> trajets = new ArrayList<>();

    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    private List<Evaluation>evaluations = new ArrayList<>();

}
