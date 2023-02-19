package model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Ticket(private val spotNumber: Int, private val entryDateTime: LocalDateTime = LocalDateTime.now()) {
    fun getSpotNumber() = spotNumber

    fun getEntryDateTime() = entryDateTime

    override fun toString():String {
        return """
            Spot number: $spotNumber
            \n
            Entry time: ${entryDateTime.format(DateTimeFormatter.ISO_DATE)}
        """.trimIndent()
    }
}