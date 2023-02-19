package model

class FeeCalculator : Chargeable {
    override fun calculate(hours: Long): Long {
        return 10 * hours
    }
}
