package com.example.koinsample.repo

import com.example.koinsample.logger.Logger
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.*

const val TIME_FORMAT = "yyyy/MM/dd HH:mm:ss"

class RepositoryImpl(
    private val logger: Logger
) : Repository {

    init {
        logger.d("initialising repo")
    }

    override fun fetch() = flow {
        val date = getCurrentDateTime().toString(TIME_FORMAT)
        logger.d("emitting at $date")
        emit("Some value emitted at $date")
    }

    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}