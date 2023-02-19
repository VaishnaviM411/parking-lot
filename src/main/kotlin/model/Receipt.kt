package model

import java.time.LocalDateTime

class Receipt(
    ticket: Ticket,
    private val exitDateTime: LocalDateTime = LocalDateTime.now(),
    feeCalculator: Chargeable
) {
    private val spotNumber = ticket.getSpotNumber()
    private var entryDateTime = ticket.getEntryDateTime()
    private val fee = feeCalculator.calculate(entryDateTime, exitDateTime)

    fun getSpotNumber() = spotNumber

    fun getEntryDateTime() = entryDateTime

    fun getExitDateTime() = exitDateTime

    fun getFee() = fee
}
