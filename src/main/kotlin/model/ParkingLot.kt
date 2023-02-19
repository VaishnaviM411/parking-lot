package model

import exception.SpotNotFoundInParkingLotException

class ParkingLot(val numberOfSpots: Int) {
    var spots = MutableList(numberOfSpots) { Spot() }
    private var numberOfAvailableSpots = numberOfSpots

    fun isSpotAvailable() = numberOfAvailableSpots > 0

    fun isSpotAvailable(spot: Spot): Boolean {
        spots.forEach { if (it.getSpotNumber() == spot.getSpotNumber()) return it.isAvailable() }
        return false
    }

    fun decreaseAvailableSpots() {
        numberOfAvailableSpots--
    }

    fun getNextAvailableSpot(): Spot? {
        spots.forEach {
            if (it.isAvailable()) return it
        }
        return null
    }

    fun park(spot: Spot): Ticket {
        val spotInParkingLot =
            spots.find { it.getSpotNumber() == spot.getSpotNumber() }
                ?: throw SpotNotFoundInParkingLotException()

        spotInParkingLot.book(Vehicle())

        return Ticket(spot.getSpotNumber())
    }
}