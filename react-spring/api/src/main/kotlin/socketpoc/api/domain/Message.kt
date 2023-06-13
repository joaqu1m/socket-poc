package socketpoc.api.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.Date

@Entity
class Message {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0

    @ManyToOne
    var from: User = User()

//    @ManyToOne
//    val to: User = User()

    @Column(length = 512)
    var msg: String? = null

    var sentAt: Date? = null
}