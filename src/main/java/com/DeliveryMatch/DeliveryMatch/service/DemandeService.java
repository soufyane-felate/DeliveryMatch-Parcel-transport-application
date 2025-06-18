package com.DeliveryMatch.DeliveryMatch.service;



import com.DeliveryMatch.DeliveryMatch.Dto.DemandeDto;
import com.DeliveryMatch.DeliveryMatch.Mapper.DemandeMapper;
import com.DeliveryMatch.DeliveryMatch.Model.Demande;
import com.DeliveryMatch.DeliveryMatch.Repository.DemandeRepository;
import com.DeliveryMatch.DeliveryMatch.Repository.ExpediteurRepository;
import com.DeliveryMatch.DeliveryMatch.Repository.TrajetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DemandeService {

    private final DemandeMapper demandeMapper;
    private final DemandeRepository demandeRepository;
    private final ExpediteurRepository expediteurRepository;
    private final TrajetRepository trajetRepository;

    public DemandeDto AddDemande(DemandeDto demandeDto){
        var expediteur = expediteurRepository.findById(demandeDto.getIdExpediteur()).orElse(null);
        var trajet = trajetRepository.findById(demandeDto.getIdTrajet()).orElse(null);

        var resultat = demandeRepository.save(new Demande(null,demandeDto.getDimension() , demandeDto.getPoids() , demandeDto.getType() , expediteur , trajet));

        return demandeMapper.ToDemandeDTO(resultat);

    }

    public List<DemandeDto> getAllDemandes(){
        return demandeRepository.findAll().stream()
                .map(demande -> demandeMapper.ToDemandeDTO(demande))
                .toList();
    }

    public DemandeDto getDemandeById(Long id){
        return demandeRepository.findById(id)
                .map(demande-> demandeMapper.ToDemandeDTO(demande))
                .orElseThrow(()->new RuntimeException("demande not found"));
    }

    public DemandeDto UpdateDemande (DemandeDto demandeDto , Long id){
        Demande demande = demandeRepository.findById(id).get();

        demande.setDimension(demandeDto.getDimension());
        demande.setPoids(demandeDto.getPoids());
        demande.setType(demandeDto.getType());

        return demandeMapper.ToDemandeDTO(demandeRepository.save(demandeMapper.ToDemandeEntity(demandeDto)));
    }

    public void deleteById (Long id){
        demandeRepository.deleteById(id);
    }

}
