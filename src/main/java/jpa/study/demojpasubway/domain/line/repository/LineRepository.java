package jpa.study.demojpasubway.domain.line.repository;

import jpa.study.demojpasubway.domain.line.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LineRepository extends JpaRepository<Line, Long> {

    Optional<Line> findLineByLineNumber(Integer lineNumber);
}
