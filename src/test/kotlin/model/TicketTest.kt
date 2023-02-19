package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TicketTest {
    @Test
    fun `It should return a ticket`() {
        val spotNumber = 1
        val entryDateTime = LocalDateTime.now()

        val response = Ticket(spotNumber, entryDateTime)

        assertEquals(spotNumber, response.getSpotNumber())
        assertEquals(entryDateTime, response.getEntryDateTime())
    }

    @Test
    fun `It should return ticket info in string format`() {
        val spotNumber = 1
        val entryDateTime = LocalDateTime.now()
        val ticket = Ticket(spotNumber, entryDateTime)

        val response = ticket.toString()

        assertEquals("""
            Spot number: $spotNumber
            \n
            Entry time: ${entryDateTime.format(DateTimeFormatter.ISO_DATE)}
        """.trimIndent(), response)
    }
}