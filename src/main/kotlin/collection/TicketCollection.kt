package collection

import model.Ticket

class TicketCollection {
    private var ticketNumber = 1
    private val tickets = mutableListOf<Ticket>()

    fun getTicket(ticketNumber: Int): Ticket {
        return tickets.find { it.getTicketNumber() == ticketNumber }!!
    }

    fun getTicketNumber() = ticketNumber++
    fun addTicket(ticket: Ticket) {
        tickets.add(ticket)
    }
}