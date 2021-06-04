package jpa.study.demojpasubway.domain.subway.service;

import jpa.study.demojpasubway.domain.subway.entity.Subway;
import jpa.study.demojpasubway.domain.subway.repository.SubwayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubwayService {

    private SubwayRepository subwayRepository;

    public SubwayService(SubwayRepository subwayRepository) {
        this.subwayRepository = subwayRepository;
    }

    public Subway createSubway(String stationName) {
        Subway subway = new Subway(stationName);
        subwayRepository.save(subway);
        return subway;
    }

    public List<Subway> findAllSubway() {
        return subwayRepository.findAll();
    }
}
