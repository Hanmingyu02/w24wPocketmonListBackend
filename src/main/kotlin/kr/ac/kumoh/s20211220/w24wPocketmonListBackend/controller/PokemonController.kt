package kr.ac.kumoh.s20211220.w24wPocketmonListBackend.controller

import kr.ac.kumoh.s20211220.w24wPocketmonListBackend.model.Pokemon
import kr.ac.kumoh.s20211220.w24wPocketmonListBackend.service.PokemonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PokemonController(private val service: PokemonService) {
    @GetMapping("/api/pokemons")
    fun getAllPokemon(): List<Pokemon> = service.getAllPokemons()
}