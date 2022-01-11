package com.jemersoft.challenge.utils;

public class utils {

    private static String URL_API = "https://pokeapi.co/api/v2/pokemon?offset=count&limit=limitItems";
    private static String URL_POKEMON = "https://pokeapi.co/api/v2/pokemon/name/";

    public static String getURL(int offset, int limit) {
        return URL_API.replace("count", String.valueOf(offset)).replace("limitItems", String.valueOf(limit));
    }

    public static String getURLPokmeon(String name) {
        return URL_POKEMON.replace("name", name);
    }

}
