package jpa.study.demojpasubway.domain.line.service;

import jpa.study.demojpasubway.api.dto.LineCreateDto;
import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.repository.LineRepository;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import jpa.study.demojpasubway.domain.subway.entity.Subway;
import jpa.study.demojpasubway.domain.subway.repository.SubwayRepository;

import java.util.Optional;

@Service
public class LineService {

    private final LineRepository lineRepository;
    private final SubwayRepository subwayRepository;

    public LineService(LineRepository lineRepository,
        SubwayRepository subwayRepository) {
        this.lineRepository = lineRepository;
        this.subwayRepository = subwayRepository;
    }

    public Line createLine(LineCreateDto lineCreateDto) {
        Line line = lineRepository.findLineByLineNumber(lineCreateDto.getLineNumber());
        if (line != null) {
            throw new RuntimeException("already exists");
        }

        String stationName = lineCreateDto.getSubwayNames().get(0);
        Subway subwayByStationName = subwayRepository.findSubwayByStationName(stationName);

        line = new Line(lineCreateDto.getLineNumber(), lineCreateDto.getLineName());
        Line savedLine = lineRepository.save(line);
        if (subwayByStationName == null) {
            Subway subway = new Subway(stationName, savedLine);
            subwayRepository.save(subway);
        }

        return savedLine;
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
