package jpa.study.demojpasubway.api.dto;

import jpa.study.demojpasubway.domain.line.entity.Line;

public class SubwayUpdateDto {
    private String stationName;
    private Integer lineNumber;
    private Line line;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
