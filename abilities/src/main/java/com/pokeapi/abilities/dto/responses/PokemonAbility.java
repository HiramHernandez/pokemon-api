package com.pokeapi.abilities.dto.responses;

import com.google.gson.annotations.SerializedName;
import com.pokeapi.abilities.dto.AbilityRecord;

import java.util.List;

public class PokemonAbility {
    private List<AbilityDetail> abilities;

    public List<AbilityDetail> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityDetail> abilities) {
        this.abilities = abilities;
    }


}

