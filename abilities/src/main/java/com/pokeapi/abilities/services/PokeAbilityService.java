package com.pokeapi.abilities.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import com.pokeapi.abilities.dto.responses.PokemonAbility;

//https://pokeapi.co/api/v2/pokemon/pikachu
public interface PokeAbilityService {
    @GET("pokemon/{name}")
    Call<PokemonAbility> getAbilities(@Path("name") String name);
}
