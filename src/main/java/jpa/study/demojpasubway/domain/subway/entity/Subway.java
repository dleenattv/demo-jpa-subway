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
}
