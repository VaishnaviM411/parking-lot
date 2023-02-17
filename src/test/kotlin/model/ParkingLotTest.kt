package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ParkingLotTest {
    @Test
    fun `It should return true when spot is available`() {
        val parkingLot = ParkingLot(numberOfSpots = 100)

        val response = parkingLot.isSpotAvailable()

        assertEquals(true, response)
    }

    @Test
    fun `It should return false when spot is not available`() {
        val parkingLot = ParkingLot(numberOfSpots = 100)
        parkingLot.spots.forEach {
            val vehicle = Vehicle()
            it.book(vehicle)
            parkingLot.decreaseAvailableSpots()
        }

        val response = parkingLot.isSpotAvailable()

        assertEquals(false, response)
    }

    @Test
    fun `It should return spot when available`() {
        val parkingLot = ParkingLot(100)

        val response = parkingLot.getNextAvailableSpot()

        assertEquals(1, response?.getSpotNumber())
    }


}