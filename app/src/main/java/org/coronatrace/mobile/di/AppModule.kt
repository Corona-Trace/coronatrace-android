package org.coronatrace.mobile.di

import org.coronatrace.presentation.intro.IntroViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { IntroViewModel() }
}