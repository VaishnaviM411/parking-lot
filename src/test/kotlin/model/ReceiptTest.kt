package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import stub.DummyFeeCalculator
import java.time.LocalDateTime

class ReceiptTest {
    @Test
    fun `It should return receipt with given details`() {
        val entryDateTime = LocalDateTime.now()
        val exitDateTime = entryDateTime.plusHours(2)
        val ticket = Ticket(1, entryDateTime)
        val dummyFeeCalculator = DummyFeeCalculator()

        val receipt = Receipt(ticket, exitDateTime, dummyFeeCalculator)

        assertEquals(1,receipt.getSpotNumber())
        assertEquals(entryDateTime, receipt.getEntryDateTime())
        assertEquals(exitDateTime, receipt.getExitDateTime())
        assertEquals(40, receipt.getFee())
    }
}