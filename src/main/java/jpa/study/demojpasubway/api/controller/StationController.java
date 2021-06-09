package jpa.study.demojpasubway.api.controller;

import jpa.study.demojpasubway.api.dto.StationCreateDto;
import jpa.study.demojpasubway.api.dto.StationUpdateDto;
import jpa.study.demojpasubway.domain.station.entity.Station;
import jpa.study.demojpasubway.domain.station.service.StationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("/stations")
    public Station createStation(@Valid StationCreateDto stationCreateDto) throws Exception {
        return stationService.createStation(stationCreateDto);
    }

    @GetMapping("/stations")
    public List<Station> findAllStation() {
        return stationService.findAllStation();
    }

    @GetMapping("/stations/{id}")
    public Optional<Station> findStationById(@PathVariable Long id) {
        return stationService.findStationById(id);
    }

    @GetMapping("/stations/line/{lineNumber}")
    public List<Station> findStationsByLineNumber(@PathVariable Integer lineNumber) {
        return stationService.findStationsByLineNumber(lineNumber);
    }

    @PutMapping("/stations/line/{id}")
    public Station updateStation(@PathVariable Long id, @RequestBody StationUpdateDto stationUpdateDto) throws Exception {
        return stationService.updateStation(id, stationUpdateDto);
    }

    @DeleteMapping("/stations/{id}")
    public void deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
    }
}
