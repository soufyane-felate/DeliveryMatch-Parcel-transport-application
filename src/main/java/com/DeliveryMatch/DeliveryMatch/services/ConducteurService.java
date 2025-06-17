package com.DeliveryMatch.DeliveryMatch.services;

import com.DeliveryMatch.DeliveryMatch.dto.TrajetDto;
import com.DeliveryMatch.DeliveryMatch.entities.Colis;
import com.DeliveryMatch.DeliveryMatch.entities.Conducteur;
import com.DeliveryMatch.DeliveryMatch.entities.Demande;
import com.DeliveryMatch.DeliveryMatch.entities.Trajet;
import com.DeliveryMatch.DeliveryMatch.repository.ConducteurRepository;
import com.DeliveryMatch.DeliveryMatch.repository.DemandeRepository;
import com.DeliveryMatch.DeliveryMatch.repository.TrajetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConducteurService {

    private final ConducteurRepository conducteurRepo;
    private final TrajetRepository trajetRepo;
    private final DemandeRepository demandeRepo;

    public Trajet publierTrajet(Long conducteurId, TrajetDto dto) {
        Conducteur conducteur = conducteurRepo.findById(conducteurId)
                .orElseThrow(() -> new RuntimeException("Conducteur non trouvé"));

        Trajet trajet = new Trajet();
        trajet.setLieuDepart(dto.getLieuDepart());
        trajet.setDestination(dto.getDestination());
        trajet.setEtapes(dto.getEtapes());
        trajet.setTypeMarchandise(dto.getTypeMarchandise());
        trajet.setDimensionsMax(dto.getDimensionsMax());
        trajet.setCapaciteDisponible(dto.getCapaciteDisponible());
        trajet.setConducteur(conducteur);

        return trajetRepo.save(trajet);
    }

    public List<Demande> getDemandesPourConducteur(Long conducteurId) {
        return demandeRepo.findByTrajet_Conducteur_Id(conducteurId);
    }

    public void accepterDemande(Long demandeId) {
        Demande demande = demandeRepo.findById(demandeId)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));
        demande.setStatut(StatutDemande.ACCEPTEE);
        demandeRepo.save(demande);
    }

    public void refuserDemande(Long demandeId) {
        Demande demande = demandeRepo.findById(demandeId)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));
        demande.setStatut(StatutDemande.REFUSEE);
        demandeRepo.save(demande);
    }

    public List<Colis> consulterHistorique(Long conducteurId) {
        List<Demande> demandes = demandeRepo.findByTrajet_Conducteur_IdAndStatut(conducteurId, StatutDemande.ACCEPTEE);
        return demandes.stream().map(Demande::getColis).toList();
    }
}

