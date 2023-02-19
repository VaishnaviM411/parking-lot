package model

import error.SpotAlreadyEmptyError
import error.SpotNotAvailableError
import exception.SpotNotFoundInParkingLotException

class ParkingLot(numberOfSpots: Int) {
    private val spots = mutableListOf<Spot>()

    init {
        for (spotNumber in 1..numberOfSpots) {
            spots.add(Spot(spotNumber))
        }
    }

    fun getNextAvailableSpot(): Spot {
        return spots.find { it.isAvailable() } ?: throw SpotNotAvailableError()
    }

    fun park(spot: Spot): Ticket {
        val spotInParkingLot =
            spots.find { it.getSpotNumber() == spot.getSpotNumber() } ?: throw SpotNotFoundInParkingLotException()

        spotInParkingLot.book(Vehicle())

        return Ticket(spotInParkingLot.getSpotNumber())
    }

    fun unpark(ticket: Ticket): Receipt {
        val spotInParkingLot =
            spots.find { it.getSpotNumber() == ticket.getSpotNumber() } ?: throw SpotNotFoundInParkingLotException()

        if (spotInParkingLot.isAvailable()) {
            throw SpotAlreadyEmptyError()
        }

        spotInParkingLot.unbook()

        return Receipt(ticket)
    }
}