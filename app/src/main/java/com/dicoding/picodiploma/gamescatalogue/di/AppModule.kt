package com.dicoding.picodiploma.gamescatalogue.di

import com.dicoding.picodiploma.core.domain.usecase.GameUseCase
import com.dicoding.picodiploma.core.domain.usecase.GamesInteractor
import com.dicoding.picodiploma.gamescatalogue.detail.DetailGameViewModel
import com.dicoding.picodiploma.gamescatalogue.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> { GamesInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailGameViewModel(get()) }
}