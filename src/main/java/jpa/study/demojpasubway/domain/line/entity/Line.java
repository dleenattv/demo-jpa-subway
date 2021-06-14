package jpa.study.demojpasubway.domain.line.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jpa.study.demojpasubway.domain.station.entity.Station;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LINE_ID")
    private Long lineId;

    @Column
    private Integer lineNumber;

    @Column
    private String lineName;

    @OneToMany(mappedBy = "line", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Station> stations = new ArrayList<>();

    public Line() {
    }

    public Line(Integer lineNumber, String lineName) {
        this.lineNumber = lineNumber;
        this.lineName = lineName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public String getLineName() {
        return lineName;
    }

    public List<Station> getStations() {
        return stations;
    }
}
