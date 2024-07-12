package com.pokeapi.abilities.configuration;

import com.pokeapi.abilities.services.PokeAbilityService;
import com.pokeapi.abilities.services.impl.PokeAbilityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

import com.pokeapi.abilities.utility.Constants;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofigConfig {
    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public PokeAbilityService pokeAbilityService(Retrofit retrofit){
        return retrofit.create(PokeAbilityService.class);
    }

}
