package com.jgharris314.tgems.requestBodies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePitStatus {
    private final Integer pit_id;
    private final Integer employee_id;

    @JsonCreator
    public UpdatePitStatus(
            @JsonProperty("pit_id") Integer pit_id,
            @JsonProperty("employee_id") Integer employee_id
    ) {
        this.pit_id = pit_id;
        this.employee_id = employee_id;
    }

    public Integer getPitId() {
        return this.pit_id;
    }

    public Integer getEmployeeId() {
        return this.employee_id;
    }
}
