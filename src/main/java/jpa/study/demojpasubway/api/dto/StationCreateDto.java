package jpa.study.demojpasubway.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StationCreateDto {

    @NotBlank
    private String stationName;

    @NotNull
    private Integer lineNumber;

    public String getStationName() {
        return stationName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
}
