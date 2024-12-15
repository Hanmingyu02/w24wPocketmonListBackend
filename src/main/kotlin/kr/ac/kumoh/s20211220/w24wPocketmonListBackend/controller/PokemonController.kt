package kr.ac.kumoh.s20211220.w24wPocketmonListBackend.controller

import kr.ac.kumoh.s20211220.w24wPocketmonListBackend.model.Pokemon
import kr.ac.kumoh.s20211220.w24wPocketmonListBackend.service.PokemonService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pokemons")
@CrossOrigin(origins = ["https://wsp2024pokemonfrontend.netlify.app/", "http://localhost:3000"])
class PokemonController(private val service: PokemonService) {
    @PostMapping
    fun addPokemon(@RequestBody pokemon: Pokemon): Pokemon = service.addPokemon(pokemon)

    @GetMapping
    fun getAllPokemons(): List<Pokemon> = service.getAllPokemons()

    @GetMapping("/{id}")
    fun getPokemonById(@PathVariable id: String): Pokemon? = service.getPokemonById(id)

    @GetMapping("/name/{name}")
    fun getPokemonByName(@PathVariable name: String): List<Pokemon> = service.getPokemonByName(name)

    @PutMapping("/{id}")
    fun updatePokemon(@PathVariable id: String, @RequestBody pokemonDetails: Pokemon): Pokemon? =  service.updateSong(id, pokemonDetails)

    @DeleteMapping("/{id}")
    fun deletePokemon(@PathVariable id: String): Map<String, String> {
        return if (service.deletePokemon(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}