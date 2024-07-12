package com.pokeapi.abilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeapi.abilities.dto.responses.PokemonAbility;
import com.pokeapi.abilities.services.PokeAbilityService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@SpringBootTest
public class PokemonAbilitiesControllerTest {
    @Autowired
    PokeAbilityService pokeAbilityService;

    @Test
    public void testPokemonFound() throws IOException, JSONException {
        String jsonResponse = """
                        {
                          "abilities": [
                            {
                              "ability": {
                                "name": "static",
                                "url": "https://pokeapi.co/api/v2/ability/9/"
                              }
                            },
                            {
                              "ability": {
                                "name": "lightning-rod",
                                "url": "https://pokeapi.co/api/v2/ability/31/"
                              }
                            }
                          ]
                        }        
        """;



        Call<PokemonAbility> call = pokeAbilityService.getAbilities("pikachu");
        Response<PokemonAbility> response = call.execute();
        String jsonResponseExpected = new ObjectMapper().writeValueAsString(response.body());
        int expectedStatusCode = 200;
        int statusCode = response.code();
        System.out.println(jsonResponseExpected);
        System.out.println(jsonResponse);
        org.junit.jupiter.api.Assertions.assertEquals(expectedStatusCode, statusCode);
        JSONAssert.assertEquals(jsonResponseExpected, jsonResponse, false);

    }

    @Test
    public void testPokemonNoFound() throws IOException {
        String namePokemon = "goku";
        Call<PokemonAbility> call = pokeAbilityService.getAbilities(namePokemon);
        Response<PokemonAbility> response = call.execute();
        int expectedStatusCode = 404;
        int statusCode = response.code();
        org.junit.jupiter.api.Assertions.assertEquals(expectedStatusCode, statusCode);
    }
}
