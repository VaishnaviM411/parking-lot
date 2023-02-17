package model

class Fee {

    fun calculate(hours: Long): Long {
        return 10 * hours
    }
}
