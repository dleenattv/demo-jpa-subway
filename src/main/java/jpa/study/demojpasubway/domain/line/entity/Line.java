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
}
