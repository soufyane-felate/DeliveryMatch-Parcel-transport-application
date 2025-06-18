package com.DeliveryMatch.DeliveryMatch.Mapper;


import com.DeliveryMatch.DeliveryMatch.Dto.DemandeDto;
import com.DeliveryMatch.DeliveryMatch.Model.Demande;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DemandeMapper {

    DemandeDto ToDemandeDTO (Demande demande);
    Demande ToDemandeEntity (DemandeDto demandeDto);


}