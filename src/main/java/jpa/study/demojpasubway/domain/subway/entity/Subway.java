package jpa.study.demojpasubway.domain.subway.entity;

import jpa.study.demojpasubway.domain.line.entity.Line;

import javax.persistence.*;

@Entity
public class Subway {

    @Id
    @GeneratedValue
    private Long stationId;
    private String stationName;
    @ManyToOne
    @JoinColumn(name="LINE_ID")
    private Line line;

    public Subway() {
    }

    public Subway(String stationName) {
        this.stationName = stationName;
    }

    public Subway(String stationName, Line line) {
        this.stationName = stationName;
        this.line = line;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
