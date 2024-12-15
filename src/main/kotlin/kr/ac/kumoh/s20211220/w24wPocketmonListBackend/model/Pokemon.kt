package kr.ac.kumoh.s20211220.w24wPocketmonListBackend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "pocketmons")
data class Pokemon(
    @Id val id: String? = null,
    val number: String,
    val name: String,
    val explanation: String,
    val imageSrc: String
)
