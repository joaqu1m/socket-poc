package socketpoc.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import socketpoc.api.domain.Message

@Repository
interface MessageRepository: JpaRepository<Message, Int> {
}