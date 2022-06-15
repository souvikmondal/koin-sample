package com.example.koinsample.di

import com.example.koinsample.logger.Logger
import com.example.koinsample.logger.LoggerImpl
import com.example.koinsample.view.FirstFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val appModule = module {
    fragment {
        FirstFragment()
    }
    single<Logger> {
        LoggerImpl("com.example.koinsample")
    }
}