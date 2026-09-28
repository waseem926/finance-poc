package com.aifinance.poc.features.splash.di

import com.aifinance.poc.features.splash.data.SplashRepositoryImpl
import com.aifinance.poc.features.splash.domain.SplashRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Hilt bindings for `splash`. */
@Module
@InstallIn(SingletonComponent::class)
abstract class SplashModule {
    @Binds
    @Singleton
    abstract fun bindSplashRepository(
        impl: SplashRepositoryImpl,
    ): SplashRepository
}