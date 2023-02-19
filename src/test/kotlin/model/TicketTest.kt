package model

import collection.TicketCollection
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TicketTest {

    private val dummyTicketCollection = TicketCollection()

    @Test
    fun `It should return a ticket`() {
        val spotNumber = 1
        val entryDateTime = LocalDateTime.now()

        val response = Ticket(spotNumber, entryDateTime, dummyTicketCollection)

        assertEquals(spotNumber, response.getSpotNumber())
        assertEquals(entryDateTime, response.getEntryDateTime())
    }

    @Test
    fun `It should return ticket info in string format`() {
        val spotNumber = 1
        val entryDateTime = LocalDateTime.now()
        val ticket = Ticket(spotNumber, entryDateTime, dummyTicketCollection)

        val response = ticket.toString()

        assertEquals(
            """
            Ticket
            Spot number: $spotNumber
            Entry time: ${entryDateTime.format(DateTimeFormatter.ISO_DATE_TIME)}
        """.trimIndent(), response
        )
    }
}