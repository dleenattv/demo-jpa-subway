package jpa.study.demojpasubway.api.controller;

import jpa.study.demojpasubway.api.dto.SubwayCreateDto;
import jpa.study.demojpasubway.domain.subway.entity.Subway;
import jpa.study.demojpasubway.domain.subway.service.SubwayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SubwayController {
    private SubwayService subwayService;

    public SubwayController(SubwayService subwayService) {
        this.subwayService = subwayService;
    }

    @PostMapping("/stations")
    public Subway createSubway(SubwayCreateDto subwayCreateDto) {
        return subwayService.createSubway(subwayCreateDto);
    }

    @GetMapping("/stations")
    public List<Subway> findAllSubway() {
        return subwayService.findAllSubway();
    }

    @GetMapping("/stations/{id}")
    public Optional<Subway> findSubwayById(Long id) {
        return subwayService.findSubwayById(id);
    }

    
}
