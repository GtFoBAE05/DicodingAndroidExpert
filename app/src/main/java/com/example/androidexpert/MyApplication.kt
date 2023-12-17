package com.example.androidexpert

import android.app.Application
import com.example.androidexpert.core.di.databaseModule
import com.example.androidexpert.core.di.networkModule
import com.example.androidexpert.core.di.repositoryModule
import com.example.androidexpert.di.useCaseModule
import com.example.androidexpert.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}