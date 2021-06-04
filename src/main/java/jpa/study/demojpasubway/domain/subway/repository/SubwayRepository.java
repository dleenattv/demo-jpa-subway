package jpa.study.demojpasubway.domain.subway.repository;

import jpa.study.demojpasubway.domain.subway.entity.Subway;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubwayRepository extends JpaRepository<Subway, Long> {
}
