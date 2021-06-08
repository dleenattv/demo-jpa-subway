package jpa.study.demojpasubway.api.controller;

import jpa.study.demojpasubway.api.dto.LineCreateDto;
import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.service.LineService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping("/lines")
    public Line createLine(@Valid LineCreateDto lineCreateDto) throws Exception {
        return lineService.createLine(lineCreateDto);
    }

    @GetMapping("/lines/{lineNumber}")
    public Line findLineByLineNumber(@PathVariable Integer lineNumber) {
        return lineService.findLineByLineNumber(lineNumber);
    }

    @DeleteMapping("/lines/{lineId}")
    public void deleteLineById(@PathVariable Long lineId) {
        lineService.deleteLine(lineId);
    }
}
