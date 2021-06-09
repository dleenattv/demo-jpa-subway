package jpa.study.demojpasubway.api.dto;

import javax.validation.constraints.NotNull;

public class StationUpdateDto {

    @NotNull
    private String stationName;

    @NotNull
    private Integer lineNumber;

    public String getStationName() {
        return stationName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }
}
