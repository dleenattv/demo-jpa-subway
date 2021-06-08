package jpa.study.demojpasubway.api.dto;

import javax.validation.constraints.NotNull;

public class LineCreateDto {

    @NotNull
    private Integer lineNumber;

    @NotNull
    private String lineName;

    public Integer getLineNumber() {
        return lineNumber;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
}
