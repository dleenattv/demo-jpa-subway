package jpa.study.demojpasubway.api.dto;

import com.sun.istack.Nullable;
import jpa.study.demojpasubway.domain.line.entity.Line;

import javax.validation.constraints.NotNull;

public class StationUpdateDto {

    @NotNull
    private String stationName;

    @NotNull
    private Integer lineNumber;

    @Nullable
    private Line line;

    public String getStationName() {
        return stationName;
    }

    public Line getLine() {
        return line;
    }
}
