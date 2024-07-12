package com.pokeapi.abilities;



import com.pokeapi.abilities.dto.responses.PokemonAbility;
import com.pokeapi.abilities.services.PokeAbilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;


@SpringBootTest
class AbilitiesApplicationTests {
   @Autowired
    PokeAbilityService pokeAbilityService;



}
