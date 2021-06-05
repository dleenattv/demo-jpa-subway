package jpa.study.demojpasubway.api.dto;

import jpa.study.demojpasubway.domain.line.entity.Line;

public class SubwayUpdateDto {

    private String stationName;
    private Integer lineNumber;
    private Line line;

    public String getStationName() {
        return stationName;
    }

    public Line getLine() {
        return line;
    }
}
