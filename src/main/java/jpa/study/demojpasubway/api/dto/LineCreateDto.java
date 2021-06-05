package jpa.study.demojpasubway.api.dto;

import java.util.List;

public class LineCreateDto {

    private Integer lineNumber;
    private String lineName;
    private List<String> subwayNames;

    public Integer getLineNumber() {
        return lineNumber;
    }

    public String getLineName() {
        return lineName;
    }
}
