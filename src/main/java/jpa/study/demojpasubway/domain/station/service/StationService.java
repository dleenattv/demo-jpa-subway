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

    public Station createStation(StationCreateDto stationCreateDto) throws Exception {
        Line line = lineService.findLineByLineNumber(stationCreateDto.getLineNumber());
        Station station = new Station();
        if (line == null) {     // null 일때 line 을 insert 하고싶은데, line insert 시 station 이 필요해서 빙글빙글 도는 느낌
            throw new Exception("Line does not exist");
        } else {
            station = new Station(stationCreateDto.getStationName(),
                                line);
            stationRepository.save(station);
        }

        return station;
    }

    public List<Station> findAllStation() {
        return stationRepository.findAll();
    }

    public Optional<Station> findStationById(Long id) {
        return stationRepository.findById(id);
    }

    // line 영속화를 하려면?
    public Station updateStation(Long id, StationUpdateDto stationUpdateDto) {
        Station station = stationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//        Line line = lineService.findLineById(station.getLine().getLineId()).orElseThrow(EntityNotFoundException::new);
        station.setLine(stationUpdateDto.getLine());
        station.setStationName(stationUpdateDto.getStationName());

        stationRepository.save(station);
        return station;
    }

    public void deleteStation(Long id) {
        Station station = stationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        stationRepository.delete(station);
    }
}
