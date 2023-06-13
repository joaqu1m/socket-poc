package socketpoc.api.dto

import java.util.Date

data class MensagemRequest (
    val msg: String,
    val sentAt: Date?,
    val from: Int
)