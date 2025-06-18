package com.DeliveryMatch.DeliveryMatch.controller;


import com.DeliveryMatch.DeliveryMatch.Dto.ConducteurDto;
import com.DeliveryMatch.DeliveryMatch.service.ConducteurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ConducteurController {

    public ConducteurService conducteurService;

    @GetMapping("/AllConducteurs")
    public List<ConducteurDto> getAllConducteurS() {
        return conducteurService.getAllConducteurs();
    }
    @PostMapping("/AddConducteur")
    public ConducteurDto AddConducteur(@RequestBody  ConducteurDto conducteurDto) {
        return conducteurService.create(conducteurDto);
    }

    @GetMapping("/Conducteur/{id}")
    public ConducteurDto getConducteurById(@PathVariable Long id) {
        return conducteurService.getConducteurById(id);
    }
    @PutMapping("/Conducteur/{id}")
    public ConducteurDto updateConducteur(@RequestBody ConducteurDto conducteurDto , @PathVariable Long id) {
        return conducteurService.updateConducteur(conducteurDto, id);
    }
    @DeleteMapping("/Conducteur/{id}")
    public void deleteConducteur(@PathVariable Long id) {
        conducteurService.deleteConducteur(id);
    }
}
