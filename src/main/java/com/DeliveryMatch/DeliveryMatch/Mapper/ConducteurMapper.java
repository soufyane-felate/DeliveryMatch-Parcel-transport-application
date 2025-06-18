package com.DeliveryMatch.DeliveryMatch.Mapper;


import com.DeliveryMatch.DeliveryMatch.Dto.ConducteurDto;
import com.DeliveryMatch.DeliveryMatch.Model.Conducteur;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ConducteurMapper {

    ConducteurDto conducteurToDto(Conducteur conducteur);
    Conducteur dtoToConducteur(ConducteurDto conducteurDto);

}


