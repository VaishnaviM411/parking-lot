package model

import CAR_FEE_PER_HOUR
import util.getHours
import java.time.LocalDateTime

class FeeCalculator : Chargeable {
    override fun calculate(entryDateTime: LocalDateTime, exitDateTime: LocalDateTime): Long {
        val hours = getHours(entryDateTime, exitDateTime)

        return hours * CAR_FEE_PER_HOUR
    }
}