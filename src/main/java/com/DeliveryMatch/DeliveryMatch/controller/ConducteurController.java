package com.DeliveryMatch.DeliveryMatch.controller;

import com.DeliveryMatch.DeliveryMatch.dto.TrajetDto;
import com.DeliveryMatch.DeliveryMatch.entities.Colis;
import com.DeliveryMatch.DeliveryMatch.entities.Demande;
import com.DeliveryMatch.DeliveryMatch.entities.Trajet;
import com.DeliveryMatch.DeliveryMatch.services.ConducteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conducteurs")
@RequiredArgsConstructor
public class ConducteurController {

    private final ConducteurService conducteurService;

    @PostMapping("/{id}/trajets")
    public ResponseEntity<Trajet> publierTrajet(@PathVariable Long id, @RequestBody TrajetDto dto) {
        return ResponseEntity.ok(conducteurService.publierTrajet(id, dto));
    }

    @GetMapping("/{id}/demandes")
    public ResponseEntity<List<Demande>> voirDemandes(@PathVariable Long id) {
        return ResponseEntity.ok(conducteurService.getDemandesPourConducteur(id));
    }

    @PutMapping("/demandes/{demandeId}/accepter")
    public ResponseEntity<Void> accepterDemande(@PathVariable Long demandeId) {
        conducteurService.accepterDemande(demandeId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/demandes/{demandeId}/refuser")
    public ResponseEntity<Void> refuserDemande(@PathVariable Long demandeId) {
        conducteurService.refuserDemande(demandeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/historique")
    public ResponseEntity<List<Colis>> consulterHistorique(@PathVariable Long id) {
        return ResponseEntity.ok(conducteurService.consulterHistorique(id));
    }
}
