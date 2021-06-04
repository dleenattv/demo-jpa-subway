package jpa.study.demojpasubway.domain.line.entity;

import jpa.study.demojpasubway.domain.subway.entity.Subway;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Line {

    @Id
    @GeneratedValue
    @Column(name = "LINE_ID")
    private Long lineId;
    private Integer lineNumber;
    private String lineName;
    @OneToMany(mappedBy = "line")
    private List<Subway> stations = new ArrayList<>();


    public Line() {
    }

    public Line(Integer lineNumber, String lineName) {
        this.lineNumber = lineNumber;
        this.lineName = lineName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
}
