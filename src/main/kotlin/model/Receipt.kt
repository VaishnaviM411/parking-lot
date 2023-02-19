package model

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Receipt(ticket: Ticket, feeCalculator: FeeCalculator) {
    private var spotNumber = ticket.getSpotNumber()
    private var entryDateTime = ticket.getEntryDateTime()
    private var exitDateTime = LocalDateTime.now()
    private var fee = feeCalculator.calculate(entryDateTime.until(exitDateTime, ChronoUnit.HOURS))
}
