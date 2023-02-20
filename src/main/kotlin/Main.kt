import collection.TicketCollection
import model.ParkingLot

fun main() {
    val ticketCollection = TicketCollection()
    val parkingLot = ParkingLot(NUMBER_OF_SPOTS, ticketCollection)

    val actions = listOf("1. Park", "2. Unpark", "0. Exit")

    actions.forEach { println(it) }

    var selectedAction = readln()

    while (selectedAction != "0") {

        when (selectedAction) {
            "1" -> {
                try {
                    val spot = parkingLot.getNextAvailableSpot()
                    val ticket = parkingLot.park(spot)
                    println(ticket.toString())
                } catch (error: Error) {
                    println(error)
                } catch (exception: Exception) {
                    println(exception)
                }
            }

            "2" -> {
                try {
                    println("Enter ticket number: ")
                    val ticketNumber = readln().toInt()
                    val ticket = ticketCollection.getTicket(ticketNumber)
                    val receipt = parkingLot.unpark(ticket)
                    println(receipt.toString())
                } catch (error: Error) {
                    println(error)
                } catch (exception: Exception) {
                    println(exception)
                }
            }

            else -> {
                println("No action found!")
            }
        }

        actions.forEach { println(it) }

        selectedAction = readln()

    }
}