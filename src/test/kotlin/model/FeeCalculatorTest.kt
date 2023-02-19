package model

import FEE_PER_HOUR
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class FeeCalculatorTest {
    @Test
    fun `It should return fee for given hours`() {
        val feeCalculator = FeeCalculator()
        val entryDateTime = LocalDateTime.now()
        val exitDateTime = entryDateTime.plusHours(2)

        val response = feeCalculator.calculate(entryDateTime, exitDateTime)

        assertEquals(2 * FEE_PER_HOUR, response)
    }
}