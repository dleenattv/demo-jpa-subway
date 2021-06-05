package jpa.study.demojpasubway.domain.line.service;

import jpa.study.demojpasubway.api.dto.LineCreateDto;
import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.repository.LineRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class LineService {

    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Line createLine(LineCreateDto lineCreateDto) {
        Line line = new Line(lineCreateDto.getLineNumber(), lineCreateDto.getLineName());
        lineRepository.save(line);

        return line;
    }

    public Optional<Line> findLineById(Long id) {
        return lineRepository.findById(id);
    }

    public Line findLineByLineNumber(Integer lineNumber) {
        return lineRepository.findLineByLineNumber(lineNumber);
    }

    public void deleteLine(Long id) {
        Line line = lineRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        lineRepository.delete(line);
    }
}
