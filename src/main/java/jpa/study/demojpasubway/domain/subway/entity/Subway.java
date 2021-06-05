package jpa.study.demojpasubway.domain.subway.entity;

import jpa.study.demojpasubway.domain.line.entity.Line;

import javax.persistence.*;

@Entity
public class Subway {

    @Id
    @GeneratedValue
    private Long stationId;

    @Column
    private String stationName;

    @ManyToOne
    @JoinColumn(name = "LINE_ID")
    private Line line;

    public Subway() {
    }

    public Subway(String stationName, Line line) {
        this.stationName = stationName;
        this.line = line;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
