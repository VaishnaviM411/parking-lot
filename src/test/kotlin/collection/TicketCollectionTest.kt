package collection

import model.Ticket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicketCollectionTest {
    @Test
    fun `It should add ticket to collection`() {
        val ticketCollection = TicketCollection()
        val ticket = Ticket(1, ticketCollection = ticketCollection)
        val ticketNumber = 0

        ticketCollection.add(ticket)

        assertEquals(ticket, ticketCollection.getTicket(ticketNumber))
    }

    @Test
    fun `It should return ticket of given ticket number`() {
        val ticketCollection = TicketCollection()
        val ticket = Ticket(1, ticketCollection = TicketCollection())
        val ticketNumber = 0
        ticketCollection.add(ticket)

        val response = ticketCollection.getTicket(ticketNumber)

        assertEquals(response, ticket)
    }

    @Test
    fun `It should generate ticket number for new ticket`() {
        val ticketCollection = TicketCollection()

        val ticketNumber = ticketCollection.getTicketNumber()

        assertEquals(0, ticketNumber)
    }
}