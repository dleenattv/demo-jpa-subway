package jpa.study.demojpasubway.domain.station.repository;

import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.station.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    Station findSubwayByStationName(String stationName);
    List<Station> findStationsByLine(Line line);
}
