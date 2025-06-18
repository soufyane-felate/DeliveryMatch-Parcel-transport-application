package com.DeliveryMatch.DeliveryMatch.service;

import com.DeliveryMatch.DeliveryMatch.Dto.ConducteurDto;
import com.DeliveryMatch.DeliveryMatch.Mapper.ConducteurMapper;
import com.DeliveryMatch.DeliveryMatch.Model.Conducteur;
import com.DeliveryMatch.DeliveryMatch.Repository.ConducteurRipository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConducteurService {

    private final ConducteurRipository conducteurRipository;
    private final ConducteurMapper conducteurMapper;

    public ConducteurService(ConducteurRipository conducteurRipository, ConducteurMapper conducteurMapper) {
        this.conducteurRipository = conducteurRipository;
        this.conducteurMapper = conducteurMapper;
    }

    @Transactional
    public ConducteurDto create(ConducteurDto conducteurDto) {
        return conducteurMapper.conducteurToDto(conducteurRipository
                .save(conducteurMapper.dtoToConducteur(conducteurDto)));
    }


    public List<ConducteurDto> getAllConducteurs() {
        return conducteurRipository.findAll().stream()
                .map(conducteur->conducteurMapper.conducteurToDto(conducteur))
                .toList();
    }

    public ConducteurDto getConducteurById(Long id) {
        return conducteurRipository.findById(id)
                .map(conducteur->conducteurMapper.conducteurToDto(conducteur))
                .orElseThrow(()-> new  RuntimeException("aaaaaaaaaaaaaa"));
    }

    public ConducteurDto updateConducteur(ConducteurDto conducteurDto , Long id) {
        Conducteur conducteur = conducteurRipository.findById(id).get();
        conducteur.setEmail(conducteurDto.getEmail());
        conducteur.setFirstName(conducteurDto.getFirstName());
        conducteur.setLastName(conducteurDto.getLastName());

        return conducteurMapper.conducteurToDto(conducteurRipository
                .save(conducteurMapper.dtoToConducteur(conducteurDto)));
    }

    public void deleteConducteur(Long id) {
        conducteurRipository.deleteById(id);
    }
}
