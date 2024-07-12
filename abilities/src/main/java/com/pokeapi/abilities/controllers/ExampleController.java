package com.pokeapi.abilities.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/v1/example")
public class ExampleController {

    @Operation(summary = "List og examples")
    @GetMapping("")
    public List<String> examples(){
        List<String> examples = List.of("HOLA", "Como ", "Estas", "Adios");
        return examples;
    }

}
