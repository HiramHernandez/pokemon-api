package com.pokeapi.abilities.controllers.v1;

import com.pokeapi.abilities.exceptions.PokeApiCallError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;

import com.pokeapi.abilities.services.PokeAbilityService;
import com.pokeapi.abilities.dto.responses.PokemonAbility;
import com.pokeapi.abilities.dto.responses.ErrorResponse;

import java.io.IOException;

@RestController
@RequestMapping("/api/v2/pokemon-abilities")
public class PokemonAbilitiesController {
    @Autowired
    private PokeAbilityService pokeAbilityService;

    private Logger logger = LoggerFactory.getLogger(PokemonAbilitiesController.class);

    @Operation(summary = "Retrieve tha abilities of a specific pokemon")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PokemonAbility.class))
                    }
            )
    })
    @GetMapping("/")
    public ResponseEntity<?> abilitiesByPokemon(@RequestParam(required = true) String name) throws HttpException {
        Call<PokemonAbility> call = pokeAbilityService.getAbilities(name.toLowerCase());

        try{
            Response<PokemonAbility> response = call.execute();
            HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(response.code());
            if (httpStatusCode.is4xxClientError()){
                ErrorResponse errorResponse = new ErrorResponse(String.format("%s no existe", name));
                return ResponseEntity.status(response.code()).body(errorResponse);
            }
            return ResponseEntity.ok(response.body());

        }catch (HttpException | IOException e){
            logger.error(String.format("Ha ocurrio un error: %s", e.getMessage()));
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setError("Ocurrio un error con la solicitud por favor revise el log");
            return ResponseEntity.status(500).body(errorResponse);
        }


    }

}
