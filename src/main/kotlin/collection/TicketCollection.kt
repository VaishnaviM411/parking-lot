package collection

import model.Ticket

class TicketCollection {
    private val tickets = mutableListOf<Ticket>()

    fun add(ticket: Ticket) {
        tickets.add(ticket)
    }

    fun getTicket(ticketNumber: Int) = tickets[ticketNumber]

    fun getTicketNumber() = tickets.size
}
