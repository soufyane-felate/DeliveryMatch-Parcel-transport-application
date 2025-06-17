package com.DeliveryMatch.DeliveryMatch.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Colis {
    private double poids;
    private String type;
    @Embedded
    private Dimensions dimensions;

}
