package model

import java.time.LocalDateTime

class Ticket(private val spotNumber: Int, private val entryDateTime: LocalDateTime = LocalDateTime.now()) {
    fun getSpotNumber() = spotNumber

    fun getEntryDateTime() = entryDateTime
}