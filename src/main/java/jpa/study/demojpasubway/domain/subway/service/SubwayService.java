package jpa.study.demojpasubway.domain.subway.service;

import jpa.study.demojpasubway.api.dto.SubwayCreateDto;
import jpa.study.demojpasubway.api.dto.SubwayUpdateDto;
import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.service.LineService;
import jpa.study.demojpasubway.domain.subway.entity.Subway;
import jpa.study.demojpasubway.domain.subway.repository.SubwayRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SubwayService {

    private final SubwayRepository subwayRepository;
    private final LineService lineService;

    public SubwayService(SubwayRepository subwayRepository, LineService lineService) {
        this.subwayRepository = subwayRepository;
        this.lineService = lineService;
    }

    public Subway createSubway(SubwayCreateDto subwayCreateDto) throws Exception {
        Line line = lineService.findLineByLineNumber(subwayCreateDto.getLineNumber());
        Subway subway = new Subway();
        if (line == null) {     // null 일때 line 을 insert 하고싶은데, line insert 시 station 이 필요해서 빙글빙글 도는 느낌
            throw new Exception("Line does not exist");
        } else {
            subway = new Subway(subwayCreateDto.getStationName(),
                                line);
            subwayRepository.save(subway);
        }

        return subway;
    }

    public List<Subway> findAllSubway() {
        return subwayRepository.findAll();
    }

    public Optional<Subway> findSubwayById(Long id) {
        return subwayRepository.findById(id);
    }

    // line 영속화를 하려면?
    public Subway updateSubway(Long id, SubwayUpdateDto subwayUpdateDto) {
        Subway subway = subwayRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//        Line line = lineService.findLineById(subway.getLine().getLineId()).orElseThrow(EntityNotFoundException::new);
        subway.setLine(subwayUpdateDto.getLine());
        subway.setStationName(subwayUpdateDto.getStationName());

        subwayRepository.save(subway);
        return subway;
    }

    public void deleteSubway(Long id) {
        Subway subway = subwayRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        subwayRepository.delete(subway);
    }
}
