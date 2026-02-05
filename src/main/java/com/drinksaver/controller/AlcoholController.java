package com.drinksaver.controller;

import com.drinksaver.model.AlcoholVolumeDescription;
import com.drinksaver.model.SingleNameResponse;
import com.drinksaver.repository.AlcoholRepository;
import com.drinksaver.service.InjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/alcohol")
public class AlcoholController {

    private final AlcoholRepository alcoholRepositoriy;

    @Autowired
    public AlcoholController(InjectorService injectorService) {
        this.alcoholRepositoriy = injectorService.getAlcoholRepository("hardcoded");
    }

    @GetMapping("/types")
    public List<SingleNameResponse> getRecommendationsList(@RequestParam(defaultValue = "10") Integer amount) {
        return alcoholRepositoriy.getAlcoholTypes(amount);
    }

    @GetMapping("/types/{alcoholTypeId}/volumes")
    public List<AlcoholVolumeDescription> getVolumesByAlcoholType(@PathVariable Integer alcoholTypeId) {
        return alcoholRepositoriy.getVolumesByAlcoholType(alcoholTypeId);
    }

}
