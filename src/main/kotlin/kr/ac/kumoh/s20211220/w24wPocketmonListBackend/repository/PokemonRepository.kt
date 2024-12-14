package kr.ac.kumoh.s20211220.w24wPocketmonListBackend.repository

import kr.ac.kumoh.s20211220.w24wPocketmonListBackend.model.Pokemon
import org.springframework.data.mongodb.repository.MongoRepository

interface PokemonRepository:MongoRepository<Pokemon, String> {

    fun findByName(name: String): List<Pokemon>
}