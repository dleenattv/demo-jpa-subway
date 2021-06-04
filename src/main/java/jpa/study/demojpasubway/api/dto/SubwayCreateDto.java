package jpa.study.demojpasubway.api.dto;

public class SubwayCreateDto {
    private String stationName;
    private Integer lineNumber;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
}
