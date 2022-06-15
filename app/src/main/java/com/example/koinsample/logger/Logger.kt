package com.example.koinsample.logger

import android.util.Log

interface Logger {

    fun d(message: String)

    fun e(message: String)
}

class LoggerImpl (
    private val tag: String
) : Logger {

    override fun d(message: String) {
        Log.d(tag, message)
    }

    override fun e(message: String) {
        Log.e(tag, message)
    }
}