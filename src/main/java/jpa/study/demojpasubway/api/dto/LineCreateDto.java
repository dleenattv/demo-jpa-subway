package jpa.study.demojpasubway.api.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class LineCreateDto {

    @NotNull
    private Integer lineNumber;

    @NotNull
    private String lineName;

    private List<String> stationNames;

    public LineCreateDto(Integer lineNumber, String lineName, List<String> subwayNames) {
        this.lineNumber = lineNumber;
        this.lineName = lineName;
        this.subwayNames = subwayNames;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getSubwayNames() {
        return subwayNames;
    }
}
