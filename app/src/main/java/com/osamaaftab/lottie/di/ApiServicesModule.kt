package com.osamaaftab.lottie.di

import com.osamaaftab.lottie.data.services.AnimationServices
import com.osamaaftab.lottie.data.services.ProfileServices
import org.koin.dsl.module
import retrofit2.Retrofit

val ApiServicesModule = module {
    single { provideAnimationService(get()) }
    single { provideProfilesService(get()) }

}

fun provideAnimationService(retrofit: Retrofit): AnimationServices {
    return retrofit.create(AnimationServices::class.java)
}

fun provideProfilesService(retrofit: Retrofit): ProfileServices {
    return retrofit.create(ProfileServices::class.java)
}