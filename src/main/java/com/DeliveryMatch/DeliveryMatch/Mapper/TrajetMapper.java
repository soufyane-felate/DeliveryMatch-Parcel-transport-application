package com.DeliveryMatch.DeliveryMatch.Mapper;

import com.DeliveryMatch.DeliveryMatch.Dto.TrajetDto;
import com.DeliveryMatch.DeliveryMatch.Model.Trajet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TrajetMapper {

    TrajetDto toTrajetDto(Trajet trajet);
    Trajet toTrajet(TrajetDto trajetDto);
}
