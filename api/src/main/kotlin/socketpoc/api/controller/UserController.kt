package socketpoc.api.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import socketpoc.api.domain.User
import socketpoc.api.dto.CadastroRequest
import socketpoc.api.repository.UserRepository

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
class UserController (
    val userRepository: UserRepository
) {

    @GetMapping
    fun get(): List<User> {
        return userRepository.findAll()
    }

    @PostMapping("/cadastrar")
    fun cadastro(
        @RequestBody cadastroRequest: CadastroRequest
    ) {
        val user = User()
        user.username = cadastroRequest.username
        user.password = cadastroRequest.password
        userRepository.save(user)
        return
    }

    @PostMapping("/login")
    fun login(
        @RequestBody loginRequest: CadastroRequest
    ): ResponseEntity<Int?> {
        val usuarioEncontrado = userRepository.findByUsername(loginRequest.username)
        return if (usuarioEncontrado.isPresent) {
            if (usuarioEncontrado.get().password == loginRequest.password) {
                ResponseEntity.status(200).body(usuarioEncontrado.get().id)
            } else ResponseEntity.status(403).build()
        } else ResponseEntity.status(404).build()
    }
}