package model


class Vehicle(private val vehicleType: VehicleType = VehicleType.CAR) {
    fun getVehicleType() = vehicleType
}
