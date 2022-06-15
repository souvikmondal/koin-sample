package com.example.koinsample.di

import com.example.koinsample.repo.Repository
import com.example.koinsample.repo.RepositoryImpl
import org.koin.dsl.module

val serviceModule = module {
    factory<Repository> {
        RepositoryImpl(get())
    }
}