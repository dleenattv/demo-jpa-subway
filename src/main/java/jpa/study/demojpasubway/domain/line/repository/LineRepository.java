package jpa.study.demojpasubway.domain.line.repository;

import jpa.study.demojpasubway.domain.line.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineRepository extends JpaRepository<Line, Long> {
}
