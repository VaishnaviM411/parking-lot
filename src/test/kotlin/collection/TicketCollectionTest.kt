package collection

import exception.TicketNotFoundException
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
        val ticket = Ticket(1, ticketCollection = ticketCollection)
        val ticketNumber = 0
        ticketCollection.add(ticket)

        val response = ticketCollection.getTicket(ticketNumber)

        assertEquals(response, ticket)
    }

    @Test
    fun `It should throw error if ticket with given ticket number not found`() {
        val ticketCollection = TicketCollection()
        val ticketNumber = 1

        assertThrows(TicketNotFoundException::class.java) { ticketCollection.getTicket(ticketNumber) }
    }

    @Test
    fun `It should generate ticket number for new ticket`() {
        val ticketCollection = TicketCollection()

        val ticketNumber = ticketCollection.getTicketNumber()

        assertEquals(0, ticketNumber)
    }
}