package model

interface Chargeable {
    fun calculate(hours: Long): Long
}