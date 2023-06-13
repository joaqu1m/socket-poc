package socketpoc.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import socketpoc.api.domain.User
import java.util.Optional

@Repository
interface UserRepository: JpaRepository<User, Int> {

    fun findByUsername(username: String): Optional<User>
}