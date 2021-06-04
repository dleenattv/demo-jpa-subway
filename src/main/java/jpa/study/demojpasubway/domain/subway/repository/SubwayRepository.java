package jpa.study.demojpasubway.domain.subway.repository;

import jpa.study.demojpasubway.domain.subway.entity.Subway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubwayRepository extends JpaRepository<Subway, Long> {
    Subway findSubwayByStationName(String stationName);
}
