package com.osamaaftab.lottie.di

import com.osamaaftab.lottie.domain.repository.AnimationRepository
import com.osamaaftab.lottie.domain.repository.ProfileRepository
import com.osamaaftab.lottie.domain.usecase.GetAnimatorUsecase
import com.osamaaftab.lottie.domain.usecase.GetFeaturedUsecase
import com.osamaaftab.lottie.domain.usecase.GetPopularUsecase
import com.osamaaftab.lottie.domain.usecase.GetRecentUsecase
import com.osamaaftab.lottie.util.handler.ApiErrorHandle
import org.koin.dsl.module

val UseCaseModule = module {
    single { provideFeaturedUseCase(get(), provideApiError())}
    single { providePopularUseCase(get(), provideApiError())}
    single { provideRecentUseCase(get(), provideApiError())}
    single { provideAnimatorProfilesUseCase(get(), provideApiError())}
}

fun provideFeaturedUseCase(
    animationRepository: AnimationRepository,
    apiErrorHandle: ApiErrorHandle
): GetFeaturedUsecase {
    return GetFeaturedUsecase(animationRepository, apiErrorHandle)
}


fun providePopularUseCase(
    animationRepository: AnimationRepository,
    apiErrorHandle: ApiErrorHandle
): GetPopularUsecase {
    return GetPopularUsecase(animationRepository, apiErrorHandle)
}

fun provideRecentUseCase(
    animationRepository: AnimationRepository,
    apiErrorHandle: ApiErrorHandle
): GetRecentUsecase {
    return GetRecentUsecase(animationRepository, apiErrorHandle)
}


fun provideAnimatorProfilesUseCase(
    profileRepository: ProfileRepository,
    apiErrorHandle: ApiErrorHandle
): GetAnimatorUsecase {
    return GetAnimatorUsecase(profileRepository, apiErrorHandle)
}