package socketpoc.api.controller

import com.corundumstudio.socketio.SocketIOServer
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import socketpoc.api.domain.Message
import socketpoc.api.dto.MensagemRequest
import socketpoc.api.repository.MessageRepository
import socketpoc.api.repository.UserRepository

@RestController
@RequestMapping("/chat")
@CrossOrigin("http://localhost:3000")
class MessageController (
    val socketIOServer: SocketIOServer,
    val userRepository: UserRepository,
    val messageRepository: MessageRepository
) {

    @GetMapping
    fun getTodas(): List<Message> {
        return messageRepository.findAll()
    }

    @PostMapping
    fun enviarMsg(
        @RequestBody mensagemRequest: MensagemRequest
    ) {
        val message = Message()
        message.from = userRepository.findById(mensagemRequest.from).get()
        message.msg = mensagemRequest.msg
        message.sentAt = mensagemRequest.sentAt
        messageRepository.save(message)

        socketIOServer.namespace("/chat").sendEvent("message", message)
    }
}