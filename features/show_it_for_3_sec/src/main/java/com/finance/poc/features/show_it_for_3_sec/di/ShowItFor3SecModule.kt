package com.finance.poc.features.show_it_for_3_sec.di

import com.finance.poc.features.show_it_for_3_sec.data.ShowItFor3SecRepositoryImpl
import com.finance.poc.features.show_it_for_3_sec.domain.ShowItFor3SecRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Hilt bindings for `show_it_for_3_sec`. */
@Module
@InstallIn(SingletonComponent::class)
abstract class ShowItFor3SecModule {
    @Binds
    @Singleton
    abstract fun bindShowItFor3SecRepository(
        impl: ShowItFor3SecRepositoryImpl,
    ): ShowItFor3SecRepository
}