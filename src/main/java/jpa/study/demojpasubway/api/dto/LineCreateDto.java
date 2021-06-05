package jpa.study.demojpasubway.api.dto;

import java.util.List;

public class LineCreateDto {

    private Integer lineNumber;
    private String lineName;
    private List<String> subwayNames;

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
