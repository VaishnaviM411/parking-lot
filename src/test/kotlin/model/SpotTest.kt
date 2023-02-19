package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpotTest {
    @Test
    fun `It should return true if spot is available`() {
        val spot = Spot()

        val response = spot.isAvailable()

        assertEquals(true, response)
    }

    @Test
    fun `It should return false if spot is not available`() {
        val spot = Spot()
        spot.book(Vehicle())

        val response = spot.isAvailable()

        assertEquals(false, response)
    }

    @Test
    fun `It should book a spot by given vehicle`() {
        val spot = Spot()
        val vehicle = Vehicle()

        spot.book(vehicle)

        assertEquals(false, spot.isAvailable())
        assertEquals(vehicle, spot.getVehicle())
    }

    @Test
    fun `It should unbook a spot`() {
        val spot = Spot()
        spot.book(Vehicle())

        spot.unbook()

        assertEquals(true, spot.isAvailable())
        assertNull(spot.getVehicle())
    }
}