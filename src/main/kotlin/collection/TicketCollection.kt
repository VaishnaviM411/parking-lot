package collection

import exception.TicketNotFoundException
import model.Ticket

class TicketCollection {
    private val tickets = mutableListOf<Ticket>()

    fun add(ticket: Ticket) {
        tickets.add(ticket)
    }

    fun getTicket(ticketNumber: Int) = try {
        tickets[ticketNumber]
    } catch (exception: Exception) {
        throw TicketNotFoundException()
    }

    fun getTicketNumber() = tickets.size
}
