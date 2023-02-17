package model

class ParkingLot(val numberOfSpots: Int) {
    var spots = MutableList(100) { Spot() }
    private var numberOfAvailableSpots = numberOfSpots

    fun isSpotAvailable() = numberOfAvailableSpots > 0

    fun decreaseAvailableSpots() {
        numberOfAvailableSpots--
    }

    fun getNextAvailableSpot(): Spot? {
        spots.forEach {
            if (it.isAvailable())
                return it
        }
        return null
    }

    fun getSpotByVehicle(vehicle: Vehicle): Spot? {
        spots.forEach { if (it.getVehicle() == vehicle) return it }
        return null
    }

    fun getSpotBySpotNumber(spotNumber: Int): Spot? {
        spots.forEach { if (it.getSpotNumber() == spotNumber) return it }
        return null
    }

    fun increaseAvailableSpots() {
        numberOfAvailableSpots++
    }
}