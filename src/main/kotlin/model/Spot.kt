package model

var spotNumberCounter = 1

class Spot {
    private val spotNumber = spotNumberCounter++
    private var vehicle: Vehicle? = null

    fun book(vehicle: Vehicle) {
        this.vehicle = vehicle
    }

    fun isAvailable() = vehicle == null

    fun getSpotNumber() = spotNumber

    fun unbook() {
        this.vehicle = null
    }

    fun getVehicle() = vehicle
}
