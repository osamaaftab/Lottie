package com.osamaaftab.lottie.di

import com.osamaaftab.lottie.data.repository.AnimationRepositoryImp
import com.osamaaftab.lottie.data.repository.ProfileRepositoryImp
import com.osamaaftab.lottie.data.services.AnimationServices
import com.osamaaftab.lottie.data.services.ProfileServices
import com.osamaaftab.lottie.domain.repository.AnimationRepository
import com.osamaaftab.lottie.domain.repository.ProfileRepository
import org.koin.dsl.module

val RepositoryModule = module {

    single { provideAnimationRepository(get()) }
    single { provideProfilesRepository(get()) }

}

fun provideAnimationRepository(animationServices: AnimationServices): AnimationRepository {
    return AnimationRepositoryImp(animationServices)
}


fun provideProfilesRepository(profileServices: ProfileServices): ProfileRepository {
    return ProfileRepositoryImp(profileServices)
}