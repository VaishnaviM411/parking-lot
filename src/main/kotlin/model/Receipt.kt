package model

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Receipt(ticket: Ticket, fee: Fee) {
    private var spotNumber = ticket.getSpotNumber()
    private var entryDateTime = ticket.getEntryDateTime()
    private var exitDateTime = LocalDateTime.now()
    private var fee = fee.calculate(entryDateTime.until(exitDateTime, ChronoUnit.HOURS))

    fun getSpotNumber() = spotNumber

    fun getFee() = fee
}
