package com.jemersoft.challenge.controller;

import com.jemersoft.challenge.dto.PokemonDTO;
import com.jemersoft.challenge.dto.ResponseApiDTO;
import com.jemersoft.challenge.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping(value = "/search")
    public ResponseEntity getPokemonToAPI(@RequestParam int offset, @RequestParam int limit) {
        ResponseApiDTO response = pokemonService.getListPokemonToAPI(offset, limit);
        ResponseEntity responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/search/pokemon")
    public ResponseEntity getPokemonToAPI(@RequestParam String name) {
        PokemonDTO response = pokemonService.getPokemonToAPI(name);

        ResponseEntity responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }
}
