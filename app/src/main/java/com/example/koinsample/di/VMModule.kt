package com.example.koinsample.di

import com.example.koinsample.vm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel {
        MainViewModel(get())
    }
}