package com.DeliveryMatch.DeliveryMatch.controller;


import com.DeliveryMatch.DeliveryMatch.Dto.TrajetDto;
import com.DeliveryMatch.DeliveryMatch.service.TrajetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TrajetController {

    public TrajetService trajetService;

    @PostMapping("/AddTrajet")
    public TrajetDto AddTrajet(@RequestBody TrajetDto trajetDto){
        return trajetService.AddTrajet(trajetDto);
    }

    @GetMapping("/AllTrajets")
    public List<TrajetDto> getAllTrajets(){
        return trajetService.getAllTrajets();
    }

    @GetMapping("/Trajet/{id}")
    public TrajetDto getTrajetById(@PathVariable Long id){
        return trajetService.getTrajetById(id);
    }

    @PutMapping("/trajet/{id}")
    public TrajetDto updateTrajet(@PathVariable Long id ,@RequestBody TrajetDto trajetDto){
        return trajetService.updateTrajet(id , trajetDto);
    }
}
