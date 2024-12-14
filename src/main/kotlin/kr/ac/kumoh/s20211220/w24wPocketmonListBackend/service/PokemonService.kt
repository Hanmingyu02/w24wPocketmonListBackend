package kr.ac.kumoh.s20211220.w24wPocketmonListBackend.service

import kr.ac.kumoh.s20211220.w24wPocketmonListBackend.model.Pokemon
import kr.ac.kumoh.s20211220.w24wPocketmonListBackend.repository.PokemonRepository
import org.springframework.stereotype.Service

@Service
class PokemonService(private val repository: PokemonRepository) {
    fun getAllPokemons(): List<Pokemon> = repository.findAll()
}