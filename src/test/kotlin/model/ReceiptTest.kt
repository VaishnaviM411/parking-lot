package model

import DUMMY_FEE
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import stub.DummyFeeCalculator
import java.time.LocalDateTime
import java.util.UUID.randomUUID

class ReceiptTest {
    @Test
    fun `It should return receipt with given details`() {
        val entryDateTime = LocalDateTime.now()
        val exitDateTime = entryDateTime.plusHours(2)
        val spotNumber = randomUUID()
        val ticket = Ticket(spotNumber, entryDateTime)
        val dummyFeeCalculator = DummyFeeCalculator()

        val receipt = Receipt(ticket, exitDateTime, dummyFeeCalculator)

        assertEquals(spotNumber, receipt.getSpotNumber())
        assertEquals(entryDateTime, receipt.getEntryDateTime())
        assertEquals(exitDateTime, receipt.getExitDateTime())
        assertEquals(DUMMY_FEE, receipt.getFee())
    }
}