import collection.TicketCollection
import model.ParkingLot
import model.Ticket
import java.time.LocalDateTime

fun main() {
    val ticketCollection = TicketCollection()
    val parkingLot = ParkingLot(NUMBER_OF_SPOTS, ticketCollection)

    val actions = listOf("1. Park", "2. Unpark", "0. Exit")

    actions.forEach { println(it) }

    var selectedAction = readln().toInt()

    while (selectedAction != 0) {

        when (selectedAction) {
            1 -> {
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

            2 -> {
                try {
                    println("Enter spot number: ")
                    val spotNumber = readln().toInt()
                    println("Enter entry date time")
                    val entryDateTime = LocalDateTime.parse(readln())
                    val ticket = Ticket(spotNumber, entryDateTime, ticketCollection)
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

        selectedAction = readln().toInt()

    }
}