package jpa.study.demojpasubway.domain.line.service;

import jpa.study.demojpasubway.api.dto.LineCreateDto;
import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.repository.LineRepository;
import jpa.study.demojpasubway.domain.station.entity.Station;
import jpa.study.demojpasubway.domain.station.service.StationService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LineService {

    private final LineRepository lineRepository;
    // 순환 참조 발생 (LineController -> LineService -> StationService)
    private final StationService stationService;

    public LineService(LineRepository lineRepository, StationService stationService) {
        this.lineRepository = lineRepository;
        this.stationService = stationService;
    }

    public Line createLine(LineCreateDto lineCreateDto) throws Exception {
        Line existLine = findLineByLineNumber(lineCreateDto.getLineNumber());

        if (existLine == null) {
            Line line = new Line(lineCreateDto.getLineNumber(), lineCreateDto.getLineName());
            lineRepository.save(line);

            return line;
        } else {
            throw new Exception("Line" + lineCreateDto.getLineNumber() + " already exists.");
        }
    }

    public Line findLineByLineNumber(Integer lineNumber) {
        return lineRepository.findLineByLineNumber(lineNumber);
    }

    public void deleteLine(Long id) {
        Line line = lineRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        List<Station> stations = stationService.findStationsByLineNumber(line.getLineNumber());
        for (Station station : stations) {
            stationService.deleteStation(station.getId());
        }
        lineRepository.delete(line);
    }
}
