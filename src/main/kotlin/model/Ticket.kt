package model

import collection.TicketCollection
import java.time.LocalDateTime
import java.util.UUID
import java.util.UUID.randomUUID

class Ticket(private val spotNumber: UUID = randomUUID(), private val entryDateTime: LocalDateTime = LocalDateTime.now(), ticketCollection: TicketCollection = TicketCollection()) {
    private val ticketNumber = ticketCollection.getTicketNumber()

    init {
        ticketCollection.addTicket(this)
    }

    fun getSpotNumber() = spotNumber

    fun getEntryDateTime() = entryDateTime

    fun getTicketNumber() = ticketNumber
}