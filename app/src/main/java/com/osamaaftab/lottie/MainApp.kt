package com.osamaaftab.lottie

import android.app.Application
import com.osamaaftab.lottie.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(
                listOf(
                    AppModule,
                    ViewmodelModule,
                    UseCaseModule,
                    NetWorkModule,
                    RepositoryModule,
                    ApiServicesModule
                )
            )
        }
    }
}