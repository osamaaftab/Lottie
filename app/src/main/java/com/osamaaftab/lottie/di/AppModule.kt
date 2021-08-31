package com.osamaaftab.lottie.di

import com.osamaaftab.lottie.util.handler.ApiErrorHandle
import org.koin.dsl.module

val AppModule = module {
    single { provideApiError() }
}

fun provideApiError(): ApiErrorHandle {
    return ApiErrorHandle()
}