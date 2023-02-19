package model

import error.SpotAlreadyEmptyError
import error.SpotNotAvailableError
import exception.SpotNotFoundInParkingLotException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParkingLotTest {

    @Test
    fun `It should return spot when available`() {
        val parkingLot = ParkingLot(100)

        val response = parkingLot.getNextAvailableSpot()

        assertNotNull(response.getSpotNumber())
    }

    @Test
    fun `It should throw error when spot is not available`() {
        val parkingLot = ParkingLot(100)
        for (spot in 1..100) {
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
        val spot = Spot(101)

        assertThrows(SpotNotFoundInParkingLotException::class.java) { parkingLot.park(spot) }
    }

    @Test
    fun `It should unpark a vehicle from given spot & return receipt (only 1 spot is occupied)`() {
        val parkingLot = ParkingLot(100)
        val spot = parkingLot.getNextAvailableSpot()
        val ticket = parkingLot.park(spot)

        val receipt = parkingLot.unpark(ticket)

        assertEquals(spot.getSpotNumber(), receipt.getSpotNumber())
        assertEquals(spot, parkingLot.getNextAvailableSpot())
    }

    @Test
    fun `It should not unpark spot that is already empty`() {
        val parkingLot = ParkingLot(100)
        val ticket = Ticket(1)

        assertThrows(SpotAlreadyEmptyError::class.java) { parkingLot.unpark(ticket) }
    }
}