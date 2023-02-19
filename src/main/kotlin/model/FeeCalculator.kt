package model

import FEE_PER_HOUR

class FeeCalculator : Chargeable {
    override fun calculate(hours: Long): Long {
        return hours * FEE_PER_HOUR
    }
}
