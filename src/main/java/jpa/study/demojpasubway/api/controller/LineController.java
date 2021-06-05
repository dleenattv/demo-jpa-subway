package jpa.study.demojpasubway.api.controller;

import jpa.study.demojpasubway.api.dto.LineCreateDto;
import jpa.study.demojpasubway.domain.line.entity.Line;
import jpa.study.demojpasubway.domain.line.service.LineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping("/lines")
    public Line createLine(LineCreateDto lineCreateDto) {
        return lineService.createLine(lineCreateDto);
    }
}
