package com.example.koinsample

import android.app.Application
import com.example.koinsample.di.appModule
import com.example.koinsample.di.serviceModule
import com.example.koinsample.di.vmModule
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.KoinExperimentalAPI
import org.koin.core.context.startKoin

@KoinExperimentalAPI
class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            fragmentFactory()

            modules(
                appModule,
                serviceModule,
                vmModule
            )
        }
    }
}