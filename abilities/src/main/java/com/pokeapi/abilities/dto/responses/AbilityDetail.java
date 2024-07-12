package com.pokeapi.abilities.dto.responses;

import com.google.gson.annotations.SerializedName;
import com.pokeapi.abilities.dto.AbilityRecord;

public class AbilityDetail {
    @SerializedName("ability")
    private AbilityRecord ability;

    public AbilityRecord getAbility() {
        return ability;
    }

    public void setAbility(AbilityRecord ability) {
        this.ability = ability;
    }



}
