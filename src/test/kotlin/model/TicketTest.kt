package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicketTest {
    @Test
    fun `It should return a ticket`() {
        val spotNumber = 1

        val response = Ticket(spotNumber)

        assertEquals(spotNumber, response.getSpotNumber())
    }
}