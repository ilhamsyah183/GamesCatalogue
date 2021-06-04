package com.dicoding.picodiploma.gamescatalogue

import android.app.Application
import com.dicoding.picodiploma.core.di.databaseModule
import com.dicoding.picodiploma.core.di.networkModule
import com.dicoding.picodiploma.core.di.repositoryModule
import com.dicoding.picodiploma.gamescatalogue.di.useCaseModule
import com.dicoding.picodiploma.gamescatalogue.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
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