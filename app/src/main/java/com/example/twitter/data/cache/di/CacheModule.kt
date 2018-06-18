package com.example.twitter.data.cache.di

import com.example.twitter.data.cache.CredentialLocalDataSourceImpl
import com.example.twitter.data.datasource.CredentialLocalDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class CacheModule {

    @Binds
    @Singleton
    abstract fun provideCredentialLocal(localDataSource: CredentialLocalDataSourceImpl): CredentialLocalDataSource

}