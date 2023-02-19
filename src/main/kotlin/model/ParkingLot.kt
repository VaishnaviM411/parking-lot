package model

import error.SpotNotAvailableError
import exception.SpotNotFoundInParkingLotException

class ParkingLot(numberOfSpots: Int) {
    private var spots = MutableList(numberOfSpots) { Spot() }

    fun getNextAvailableSpot(): Spot {
        return spots.find { it.isAvailable() } ?: throw SpotNotAvailableError()
    }

    fun park(spot: Spot): Ticket {
        val spotInParkingLot =
            spots.find { it.getSpotNumber() == spot.getSpotNumber() }
                ?: throw SpotNotFoundInParkingLotException()

        spotInParkingLot.book(Vehicle())

        return Ticket(spot.getSpotNumber())
    }
}