package jpa.study.demojpasubway.domain.station.repository;

import jpa.study.demojpasubway.domain.station.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    Station findSubwayByStationName(String stationName);
}
