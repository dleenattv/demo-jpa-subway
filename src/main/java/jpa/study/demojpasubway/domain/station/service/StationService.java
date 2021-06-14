package jpa.study.demojpasubway.domain.station.service;

import jpa.study.demojpasubway.api.dto.StationCreateDto;
import jpa.study.demojpasubway.api.dto.StationUpdateDto;
import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.service.LineService;
import jpa.study.demojpasubway.domain.station.entity.Station;
import jpa.study.demojpasubway.domain.station.repository.StationRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StationService {

    private final StationRepository stationRepository;
    private final LineService lineService;

    public StationService(StationRepository stationRepository, LineService lineService) {
        this.stationRepository = stationRepository;
        this.lineService = lineService;
    }

    public Station createStation(StationCreateDto stationCreateDto) {
        Line line = lineService.findLineByLineNumber(stationCreateDto.getLineNumber());
        Station station = getStationBy(stationCreateDto, line);

        return stationRepository.save(station);
    }

    private Station getStationBy(StationCreateDto stationCreateDto, Line line) {
        Station station = new Station(line);
        station.setStationName(stationCreateDto.getStationName());

        return station;
    }

    public List<Station> findAllStation() {
        return stationRepository.findAll();
    }

    public Optional<Station> findStationById(Long id) {
        return stationRepository.findById(id);
    }

    public List<Station> findStationsByLineNumber(Integer lineNumber) {
        Line line = lineService.findLineByLineNumber(lineNumber);
        return stationRepository.findStationsByLine(line);
    }

    public Station updateStation(Long id, StationUpdateDto stationUpdateDto) throws Exception {
        Station station = getStationBy(id);
        Line line = lineService.getLineBy(stationUpdateDto.getLineNumber());
        Station changedStation = station.getStationChangedBy(line);

        return stationRepository.save(changedStation);
    }

    private Station getStationBy(Long id) {
        return stationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteStation(Long id) {
        Station station = stationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        stationRepository.delete(station);
    }
}
