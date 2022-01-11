package com.jemersoft.challenge.service;

import com.jemersoft.challenge.configuration.ApplicationConfiguration;
import com.jemersoft.challenge.dto.PokemonDTO;
import com.jemersoft.challenge.dto.ResponseApiDTO;
import com.jemersoft.challenge.exceptions.RequestException;
import com.jemersoft.challenge.utils.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApplicationConfiguration app;

    public ResponseApiDTO getListPokemonToAPI(int offset, int limit) {
        if (offset < 1 || limit < 1)
            throw new RequestException(app.getProperty("indexNotValid"), "J-400", HttpStatus.BAD_REQUEST);

        return restTemplate.getForEntity(utils.getURL(offset, limit), ResponseApiDTO.class).getBody();
    }

    public PokemonDTO getPokemonToAPI(String name) {
        if (name == null || name.length() == 0)
            throw new RequestException(app.getProperty("nameIsRequired"), "J-410", HttpStatus.BAD_REQUEST);

        return restTemplate.getForEntity(utils.getURLPokmeon(name), PokemonDTO.class).getBody();
    }
}
