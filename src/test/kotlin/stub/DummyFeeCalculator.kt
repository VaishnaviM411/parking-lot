package stub

import DUMMY_FEE
import model.Chargeable
import java.time.LocalDateTime

class DummyFeeCalculator : Chargeable {
    override fun calculate(entryDateTime: LocalDateTime, exitDateTime: LocalDateTime): Long {
        return DUMMY_FEE
    }
}
