package com.DeliveryMatch.DeliveryMatch.Mapper;


import com.DeliveryMatch.DeliveryMatch.Dto.ExpediteurDto;
import com.DeliveryMatch.DeliveryMatch.Model.Expediteur;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ExpediteurMapper {

    ExpediteurDto ToExpediteurDto (Expediteur expediteur);
    Expediteur ToExpediteurEntity (ExpediteurDto expediteurDto);
}
