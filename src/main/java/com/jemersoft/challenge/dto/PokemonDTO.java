package com.jemersoft.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDTO implements Serializable {
    private List<AbilitiesDTO> abilities;
    private SpritesDTO sprites;
    private List<TypesDTO> types;
    private List<MovesDTO> moves;
    private Long weight;
}
