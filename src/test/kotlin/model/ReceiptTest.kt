package model

import DUMMY_FEE
import collection.TicketCollection
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import stub.DummyFeeCalculator
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ReceiptTest {

    private val dummyTicketCollection = TicketCollection()
    @Test
    fun `It should return receipt with given details`() {
        val entryDateTime = LocalDateTime.now()
        val exitDateTime = entryDateTime.plusHours(2)
        val spotNumber = 1
        val ticket = Ticket(spotNumber, entryDateTime, dummyTicketCollection)
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
        val ticket = Ticket(spotNumber, entryDateTime, dummyTicketCollection)
        val receipt = Receipt(ticket, exitDateTime, DummyFeeCalculator())

        val response = receipt.toString()

        assertEquals(
            """
            Receipt
            Spot number: $spotNumber
            Entry time: ${entryDateTime.format(DateTimeFormatter.ISO_DATE_TIME)}
            Exit time: ${exitDateTime.format(DateTimeFormatter.ISO_DATE_TIME)}
            Fee: $DUMMY_FEE
        """.trimIndent(), response
        )
    }
}