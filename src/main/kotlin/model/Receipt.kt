package model

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Receipt(ticket: Ticket,private val exitDateTime: LocalDateTime = LocalDateTime.now(), feeCalculator: Chargeable) {
    private val spotNumber = ticket.getSpotNumber()
    private var entryDateTime = ticket.getEntryDateTime()
    private val fee = feeCalculator.calculate(entryDateTime.until(exitDateTime, ChronoUnit.HOURS))

    fun getSpotNumber() = spotNumber

    fun getEntryDateTime() = entryDateTime

    fun getExitDateTime() = exitDateTime

    fun getFee() = fee
}
