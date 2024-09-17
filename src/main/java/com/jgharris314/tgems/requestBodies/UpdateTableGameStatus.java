package com.jgharris314.tgems.requestBodies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateTableGameStatus {

    private final Integer table_game_id;
    private final Integer employee_id;

    @JsonCreator
    public UpdateTableGameStatus(
            @JsonProperty("table_game_id") Integer table_game_id,
            @JsonProperty("employee_id") Integer employee_id
    ) {
        this.table_game_id = table_game_id;
        this.employee_id = employee_id;
    }

    public Integer getTableGameId() {
        return this.table_game_id;
    }

    public Integer getEmployeeId() {
        return this.employee_id;
    }
}
