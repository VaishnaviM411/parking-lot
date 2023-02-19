package model

import java.time.LocalDateTime
import java.util.UUID

class Ticket(private val spotNumber: UUID, private val entryDateTime: LocalDateTime = LocalDateTime.now()) {
    fun getSpotNumber() = spotNumber

    fun getEntryDateTime() = entryDateTime
}