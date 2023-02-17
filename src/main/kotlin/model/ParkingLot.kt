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
}