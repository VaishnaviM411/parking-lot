package model

import collection.TicketCollection
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Ticket(private val spotNumber: Int, private val entryDateTime: LocalDateTime = LocalDateTime.now(), ticketCollection: TicketCollection) {
    private val ticketNumber = ticketCollection.getTicketNumber()

    init {
        ticketCollection.add(this)
    }

    fun getSpotNumber() = spotNumber

    fun getEntryDateTime() = entryDateTime

    override fun toString(): String {
        return """
            Ticket number: $ticketNumber
            Spot number: $spotNumber
            Entry time: ${entryDateTime.format(DateTimeFormatter.ISO_DATE_TIME)}
        """.trimIndent()
    }
}