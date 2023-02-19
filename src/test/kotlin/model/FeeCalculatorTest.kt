package model

import FEE_PER_HOUR
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FeeCalculatorTest {
    @Test
    fun `It should return fee for given hours`() {
        val feeCalculator = FeeCalculator()
        val hours = 4L

        val response = feeCalculator.calculate(hours)

        assertEquals(hours * FEE_PER_HOUR, response)
    }
}