package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VehicleTest {
    @Test
    fun `It should return vehicleType`() {
        val vehicle = Vehicle(VehicleType.CAR)

        val response = vehicle.getVehicleType()

        assertEquals(VehicleType.CAR, response)
    }
}