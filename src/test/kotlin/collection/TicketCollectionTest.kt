package collection

import model.Ticket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicketCollectionTest {
    @Test
    fun `It should return ticket of given ticket number`() {
        val ticketCollection = TicketCollection()
        val ticketNumber = 1
        Ticket(ticketCollection = ticketCollection)

        val ticket = ticketCollection.getTicket(ticketNumber)

        assertEquals(ticketNumber, ticket.getTicketNumber())
    }
}