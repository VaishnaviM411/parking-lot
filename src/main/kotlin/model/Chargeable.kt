package model

import java.time.LocalDateTime

interface Chargeable {
    fun calculate(entryDateTime: LocalDateTime, exitDateTime: LocalDateTime): Long
}