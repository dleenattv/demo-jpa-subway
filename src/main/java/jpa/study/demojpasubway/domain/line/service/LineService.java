package jpa.study.demojpasubway.domain.line.service;

import jpa.study.demojpasubway.api.dto.LineCreateDto;
import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.repository.LineRepository;
import jpa.study.demojpasubway.domain.station.entity.Station;
import jpa.study.demojpasubway.domain.station.repository.StationRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LineService {

    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public LineService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public Line createLine(LineCreateDto lineCreateDto) {
        return lineRepository.save(findLineByLineNumber(lineCreateDto));
    }

    private Line findLineByLineNumber(LineCreateDto lineCreateDto) {
        return lineRepository
                .findLineByLineNumber(lineCreateDto.getLineNumber())
                .orElseGet(() -> new Line(lineCreateDto.getLineNumber(), lineCreateDto.getLineName()));
    }

    public Line findLineByLineNumber(Integer lineNumber) {
        return lineRepository
                .findLineByLineNumber(lineNumber)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Line getLineBy(Integer lineNumber) throws Exception {
        return lineRepository
                .findLineByLineNumber(lineNumber)
                .orElseThrow(() -> new Exception("Line" + lineNumber + " does not exist."));
    }

    public void deleteLine(Long id) {
        Line line = lineRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        for (Station station : line.getStations()) {
            stationRepository.delete(station);
        }

        lineRepository.delete(line);
    }
}
