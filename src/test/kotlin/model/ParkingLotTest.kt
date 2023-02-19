package model

import error.SpotNotAvailableError
import exception.SpotNotFoundInParkingLotException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ParkingLotTest {
    @BeforeEach
    fun setUp() {
        spotNumberCounter = 1
    }

    @Test
    fun `It should return spot when available`() {
        val parkingLot = ParkingLot(100)

        val response = parkingLot.getNextAvailableSpot()

        assertEquals(1, response.getSpotNumber())
    }

    @Test
    fun `It should throw error when spot is not available`() {
        val parkingLot = ParkingLot(100)
        for(spot in 1..100) {
            val spotInParkingLot = parkingLot.getNextAvailableSpot()
            parkingLot.park(spotInParkingLot)
        }

        assertThrows(SpotNotAvailableError::class.java) { parkingLot.getNextAvailableSpot() }
    }

    @Test
    fun `It should park a vehicle when spot is available & return Ticket`() {
        val parkingLot = ParkingLot(100)
        val spot = parkingLot.getNextAvailableSpot()

        val ticket = parkingLot.park(spot)

        assertEquals(spot.getSpotNumber(), ticket.getSpotNumber())
        assertNotEquals(spot, parkingLot.getNextAvailableSpot())
    }

    @Test
    fun `It should throw exception if spot is not found in parkingLot`() {
        val parkingLot = ParkingLot(100)
        val spot = Spot()

        assertThrows(SpotNotFoundInParkingLotException::class.java) { parkingLot.park(spot) }
    }
}