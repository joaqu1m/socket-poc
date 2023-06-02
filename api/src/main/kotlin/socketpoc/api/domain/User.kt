package socketpoc.api.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class User (

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int
)