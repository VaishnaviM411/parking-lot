package util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class DateTimeKtTest {
    @Test
    fun `It should return hours rounded to ceil`() {
        val firstDateTime = LocalDateTime.now()
        val secondDateTime = firstDateTime.plusMinutes(100)

        val hours = getHours(firstDateTime, secondDateTime)

        assertEquals(2, hours)
    }
}