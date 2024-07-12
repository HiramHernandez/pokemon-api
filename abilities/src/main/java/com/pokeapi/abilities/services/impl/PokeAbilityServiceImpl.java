package com.pokeapi.abilities.services.impl;

import com.pokeapi.abilities.dto.responses.PokemonAbility;
import com.pokeapi.abilities.services.PokeAbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

@Service
public class PokeAbilityServiceImpl implements  PokeAbilityService{
    @Autowired
    private Retrofit retrofit;
    private PokeAbilityService pokeAbilityService;

    @Override
    public Call<PokemonAbility> getAbilities(String name) {
        return pokeAbilityService.getAbilities(name);
    }
}
