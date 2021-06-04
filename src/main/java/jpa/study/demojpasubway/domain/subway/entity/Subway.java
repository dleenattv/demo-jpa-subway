package jpa.study.demojpasubway.domain.subway.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subway {

    @Id
    @GeneratedValue
    private Long stationId;
    private String stationName;
    private Long lineId;

    public Subway() {
    }

    public Subway(String stationName) {
        this.stationName = stationName;
    }

    public Subway(String stationName, Long lineId) {
        this.stationName = stationName;
        this.lineId = lineId;
    }
}
