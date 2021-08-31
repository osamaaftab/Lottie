package com.osamaaftab.lottie.di

import com.osamaaftab.lottie.presentation.viewmodel.AnimationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewmodelModule = module {
    viewModel { AnimationViewModel(get(), get(), get(), get()) }
}