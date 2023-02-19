package model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Receipt(
    ticket: Ticket,
    private val exitDateTime: LocalDateTime = LocalDateTime.now(),
    feeCalculator: Chargeable = FeeCalculator()
) {
    private val spotNumber = ticket.getSpotNumber()
    private val entryDateTime = ticket.getEntryDateTime()
    private val fee = feeCalculator.calculate(entryDateTime, exitDateTime)

    fun getSpotNumber() = spotNumber

    fun getEntryDateTime() = entryDateTime

    fun getExitDateTime() = exitDateTime

    fun getFee() = fee

    override fun toString(): String {
        return """
            Receipt
            Spot number: $spotNumber
            Entry time: ${entryDateTime.format(DateTimeFormatter.ISO_DATE_TIME)}
            Exit time: ${exitDateTime.format(DateTimeFormatter.ISO_DATE_TIME)}
            Fee: $fee
        """.trimIndent()
    }
}
