package util

import MINUTES_IN_ONE_HOUR
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.math.ceil

fun getHours(entryDateTime: LocalDateTime, exitDateTime: LocalDateTime): Long {
    val timeDiffInMinutes = entryDateTime.until(exitDateTime, ChronoUnit.MINUTES)

    val hours = timeDiffInMinutes.div(MINUTES_IN_ONE_HOUR.toDouble())

    return ceil(hours).toLong()
}
