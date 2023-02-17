package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VehicleTest {
    @Test
    fun `It should park a vehicle when spot is available`() {
        val vehicle = Vehicle()
        val parkingLot = ParkingLot(100)

        val ticket = vehicle.park(parkingLot)

        assertEquals(1, parkingLot.getSpotByVehicle(vehicle)?.getSpotNumber())
        assertEquals(1, ticket.getSpotNumber())
    }

    @Test
    fun `It should unPark a vehicle`() {
        val parkingLot = ParkingLot(100)
        val vehicle = Vehicle()
        val ticket = vehicle.park(parkingLot)

        val receipt = vehicle.unPark(parkingLot, ticket)

        assertEquals(1, receipt.getSpotNumber())
        assertEquals(null, parkingLot.getSpotByVehicle(vehicle)?.getSpotNumber())
    }
}