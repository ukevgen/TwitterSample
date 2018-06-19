package com.example.twitter.data.cache.di

import com.example.twitter.data.cache.UserLocalDataSourceImpl
import com.example.twitter.data.datasource.UserLocalDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class CacheModule {

    @Binds
    @Singleton
    abstract fun provideUserLocal(localDataSource: UserLocalDataSourceImpl): UserLocalDataSource

}