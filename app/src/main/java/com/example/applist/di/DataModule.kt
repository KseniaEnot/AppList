package com.example.applist.di

import com.example.applist.data.source.AppDetailsNetApi
import com.example.applist.data.source.AppDetailsNetSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    /*@Provides
    @Singleton
    fun provideAppDetailsLocalDataSource(): AppDetailsLocalDataSource {
        return AppDetailsLocalDataSource()
    }*/

    @Provides
    @Singleton
    fun provideAppDetailsDBSource(api: AppDetailsNetApi): AppDetailsNetSource =
        AppDetailsNetSource(api)

}