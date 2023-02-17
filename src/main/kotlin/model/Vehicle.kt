package model

var vehicleNumberCounter = 1

class Vehicle {
    fun park(parkingLot: ParkingLot): Ticket {
        val spot = parkingLot.getNextAvailableSpot()
        spot?.book(this)

        val spotInParkingLot = parkingLot.spots.find{ it -> spot!! == it }
        parkingLot.spots[parkingLot.spots.indexOf(spotInParkingLot)] = spot!!

        parkingLot.decreaseAvailableSpots()

        return Ticket(spot.getSpotNumber())
    }

    fun unPark(parkingLot: ParkingLot, ticket: Ticket): Receipt {
        val spot = parkingLot.getSpotBySpotNumber(ticket.getSpotNumber())
        spot?.unBook()

        val spotInParkingLot = parkingLot.spots.find { it -> spot!! == it }
        parkingLot.spots[parkingLot.spots.indexOf(spotInParkingLot)] = spot!!

        parkingLot.increaseAvailableSpots()

        return Receipt(ticket, Fee())
    }

    var vehicleNumber = vehicleNumberCounter++
}
