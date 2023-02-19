package collection

import model.Ticket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicketCollectionTest {
    @Test
    fun `It should add ticket to collection`() {
        val ticketCollection = TicketCollection()
        val ticket = Ticket(1)
        val ticketNumber = 0

        ticketCollection.add(ticket)

        assertEquals(ticket, ticketCollection.getTicket(ticketNumber))
    }
}