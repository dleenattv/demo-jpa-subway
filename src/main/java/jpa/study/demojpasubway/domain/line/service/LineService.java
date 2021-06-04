package jpa.study.demojpasubway.domain.line.service;

import jpa.study.demojpasubway.api.dto.LineCreateDto;
import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.repository.LineRepository;
import org.springframework.stereotype.Service;

@Service
public class LineService {
    private LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Line createLine(LineCreateDto lineCreateDto) {
        Line line = new Line(lineCreateDto.getLineNumber(),
                lineCreateDto.getLineName());
        lineRepository.save(line);
        return line;
    }
}
