package model

import error.VehicleNotFoundError
import java.util.UUID
import java.util.UUID.randomUUID

class Spot(private val spotNumber: UUID = randomUUID()) {
    private var vehicle: Vehicle? = null

    fun book(vehicle: Vehicle) {
        this.vehicle = vehicle
    }

    fun isAvailable() = vehicle == null

    fun getSpotNumber() = spotNumber

    fun unbook() {
        this.vehicle = null
    }

    fun getVehicle() = vehicle ?: throw VehicleNotFoundError()
}
