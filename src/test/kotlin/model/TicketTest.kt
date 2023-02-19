package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.UUID.randomUUID

class TicketTest {
    @Test
    fun `It should return a ticket`() {
        val spotNumber = randomUUID()
        val entryDateTime = LocalDateTime.now()

        val response = Ticket(spotNumber, entryDateTime)

        assertEquals(spotNumber, response.getSpotNumber())
        assertEquals(entryDateTime, response.getEntryDateTime())
    }
}