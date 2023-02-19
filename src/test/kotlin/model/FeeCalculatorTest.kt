package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FeeCalculatorTest {
    @Test
    fun `It should return fee for given hours`() {
        val feeCalculator = FeeCalculator()
        val hours = 4L

        val response = feeCalculator.calculate(hours)

        assertEquals(40, response)
    }
}