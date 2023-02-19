package model

import DUMMY_FEE
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import stub.DummyFeeCalculator
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ReceiptTest {
    @Test
    fun `It should return receipt with given details`() {
        val entryDateTime = LocalDateTime.now()
        val exitDateTime = entryDateTime.plusHours(2)
        val spotNumber = 1
        val ticket = Ticket(spotNumber, entryDateTime)
        val dummyFeeCalculator = DummyFeeCalculator()

        val receipt = Receipt(ticket, exitDateTime, dummyFeeCalculator)

        assertEquals(spotNumber, receipt.getSpotNumber())
        assertEquals(entryDateTime, receipt.getEntryDateTime())
        assertEquals(exitDateTime, receipt.getExitDateTime())
        assertEquals(DUMMY_FEE, receipt.getFee())
    }

    @Test
    fun `It should return receipt info in string format`() {
        val spotNumber = 1
        val entryDateTime = LocalDateTime.now()
        val exitDateTime = entryDateTime.plusHours(4)
        val ticket = Ticket(spotNumber, entryDateTime)
        val receipt = Receipt(ticket, exitDateTime, DummyFeeCalculator())

        val response = receipt.toString()

        assertEquals(
            """
            Receipt\n
            Spot number: $spotNumber\n
            Entry time: ${entryDateTime.format(DateTimeFormatter.ISO_DATE)}\n
            Exit time: ${exitDateTime.format(DateTimeFormatter.ISO_DATE)}\n
            Fee: $DUMMY_FEE
        """.trimIndent(), response
        )
    }
}