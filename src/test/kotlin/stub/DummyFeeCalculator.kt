package stub

import DUMMY_FEE
import model.Chargeable

class DummyFeeCalculator : Chargeable {
    override fun calculate(hours: Long): Long {
        return DUMMY_FEE
    }
}
