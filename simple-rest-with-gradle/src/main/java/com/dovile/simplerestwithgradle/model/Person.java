package com.dovile.simplerestwithgradle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import javax.validation.constraints.NotBlank;


import java.util.UUID;

@Data
@AllArgsConstructor
@Getter
public class Person {

    @JsonProperty("id")
    private final UUID id;
    @JsonProperty("name")
    @NotBlank
    private final String name;
}
