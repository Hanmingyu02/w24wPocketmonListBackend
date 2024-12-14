package kr.ac.kumoh.s20211220.w24wPocketmonListBackend.service

import kr.ac.kumoh.s20211220.w24wPocketmonListBackend.model.Pokemon
import kr.ac.kumoh.s20211220.w24wPocketmonListBackend.repository.PokemonRepository
import org.springframework.stereotype.Service

@Service
class PokemonService(private val repository: PokemonRepository) {
    fun addPokemon(pokemon: Pokemon): Pokemon = repository.save(pokemon)

    fun getAllPokemons(): List<Pokemon> = repository.findAll()
    fun getPokemonById(id: String): Pokemon? = repository.findById(id).orElse(null)
    fun getPokemonByName(name: String): List<Pokemon> = repository.findByName(name)

    fun updateSong(id: String, pokemon: Pokemon): Pokemon? {
        val pokemonTarget = repository.findById(id)

        return if (pokemonTarget.isPresent) {
            val oldPokemon = pokemonTarget.get()
            val updatedPokemon = oldPokemon.copy(
                number = pokemon.number,
                name = pokemon.name,
                explanation = pokemon.explanation,
            )
            repository.save(updatedPokemon)
        } else {
            null
        }
    }

    fun deletePokemon(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}