package model

import error.VehicleNotFoundError
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.util.UUID.randomUUID

class SpotTest {
    @Test
    fun `It should return the spot number of given spot`() {
        val spotNumber = randomUUID()

        val spot = Spot(spotNumber)

        assertEquals(spotNumber, spot.getSpotNumber())
    }

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
        assertThrows(VehicleNotFoundError::class.java) { spot.getVehicle() }
    }

    @Test
    fun `It should return vehicle at that spot`() {
        val spot = Spot()
        val vehicle = Vehicle()
        spot.book(vehicle)

        val response = spot.getVehicle()

        assertEquals(vehicle, response)
    }

    @Test
    fun `It should throw error if vehicle is not found at that spot`() {
        val spot = Spot()

        assertThrows(VehicleNotFoundError::class.java) { spot.getVehicle() }
    }
}