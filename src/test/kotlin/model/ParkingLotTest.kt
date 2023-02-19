package model

import exception.SpotNotFoundInParkingLotException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows

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

    @Test
    fun `It should throw error when spot is not available`() {
        //to do
    }

    @Test
    fun `It should park a vehicle when spot is available & return Ticket`() {
        val parkingLot = ParkingLot(100)
        val spot = parkingLot.getNextAvailableSpot()!!

        val ticket = parkingLot.park(spot)

        assertEquals(spot.getSpotNumber(), ticket.getSpotNumber())
        assertEquals(false, parkingLot.isSpotAvailable(spot))
    }

    @Test
    fun `It should throw exception if spot is not found in parkingLot`() {
        val parkingLot = ParkingLot(100)
        val spot = Spot()

        assertThrows(SpotNotFoundInParkingLotException::class.java) { parkingLot.park(spot) }
    }
}