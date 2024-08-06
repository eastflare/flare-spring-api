package com.flare.rap.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CrudVO {

    @Schema(description = "데이터상태", example = "C", allowableValues = { "C", "R", "U", "D" })
    private String crudKey;

    public String getCrudKey(){
        return crudKey != null ? this.crudKey.toUpperCase() : null;
    }

}