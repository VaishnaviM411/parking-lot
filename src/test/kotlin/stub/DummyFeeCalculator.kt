package stub

import model.Chargeable

class DummyFeeCalculator : Chargeable {
    override fun calculate(hours: Long): Long {
        return hours * 20
    }
}
