package model

import error.SpotAlreadyEmptyError
import error.VehicleNotFoundError

class Spot(private val spotNumber: Int) {
    private var vehicle: Vehicle? = null

    fun book(vehicle: Vehicle) {
        this.vehicle = vehicle
    }

    fun isAvailable() = vehicle == null

    fun getSpotNumber() = spotNumber

    fun unbook() {
        if (this.isAvailable()) {
            throw SpotAlreadyEmptyError()
        }

        this.vehicle = null
    }

    fun getVehicle() = vehicle ?: throw VehicleNotFoundError()
}
