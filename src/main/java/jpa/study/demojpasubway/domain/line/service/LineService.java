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

    public Line createLine(LineCreateDto lineCreateDto) throws Exception {
        Line existLine = findLineByLineNumber(lineCreateDto.getLineNumber());
        System.out.println(lineCreateDto.getLineNumber());
//        if (existLine == null) {
//            Line line = new Line(lineCreateDto.getLineNumber(), lineCreateDto.getLineName());
//            lineRepository.save(line);
//
//            return line;
//        } else {
//            throw new Exception("Line" + lineCreateDto.getLineNumber() + " already exists.");
//        }

        Line line = existLine.isEmpty(existLine, lineCreateDto);
        System.out.println(line.getLineNumber());
        lineRepository.save(line);
        return line;
    }

    public Line findLineByLineNumber(Integer lineNumber) {
        return lineRepository.findLineByLineNumber(lineNumber);
    }

    public void deleteLine(Long id) {
        Line line = lineRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        for (Station station : line.getStations()) {
            stationRepository.delete(station);
        }

        lineRepository.delete(line);
    }
}
