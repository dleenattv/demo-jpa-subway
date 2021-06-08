package jpa.study.demojpasubway.domain.station.repository;

import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.repository.LineRepository;
import jpa.study.demojpasubway.domain.station.entity.Station;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Rollback(value = false)
class StationRepositoryTest {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private LineRepository lineRepository;

    @Test
    void findStationById() {
        Station station = stationRepository.findSubwayByStationName("홍대");
        Line line = station.getLine();
        System.out.println(line.getLineNumber());
    }
}