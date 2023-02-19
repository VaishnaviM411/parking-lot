import model.ParkingLot
import model.Ticket
import java.time.LocalDateTime

fun main() {
    val parkingLot = ParkingLot(NUMBER_OF_SPOTS)

    val actions = listOf("1. Park", "2. Unpark", "0. Exit")

    actions.forEach { println(it) }

    var selectedAction = readln().toInt()

    while (selectedAction != 0) {

        when (selectedAction) {
            1 -> {
                try {
                    val spot = parkingLot.getNextAvailableSpot()
                    val ticket = parkingLot.park(spot)
                    println(ticket)
                } catch (error: Error) {
                    println(error)
                } catch (exception: Exception){
                    println(exception)
                }
            }

            2 -> {
                println("Enter spot number: ")
                val spotNumber = readln().toInt()
//                val spotNumber = randomUUID()
                val ticket = Ticket(spotNumber, LocalDateTime.now().minusHours(4))
                val receipt = parkingLot.unpark(ticket)
                println(receipt)
            }

            else -> {
                println("No action found!")
            }
        }

        actions.forEach { println(it) }

        selectedAction = readln().toInt()

    }
}