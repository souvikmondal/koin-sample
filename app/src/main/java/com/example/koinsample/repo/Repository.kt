package com.example.koinsample.repo

import kotlinx.coroutines.flow.Flow

interface Repository {

    fun fetch(): Flow<String>
}