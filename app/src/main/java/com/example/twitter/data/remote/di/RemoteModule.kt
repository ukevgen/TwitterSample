package com.example.twitter.data.remote.di

import com.example.twitter.data.datasource.UserRemoteDataSource
import com.example.twitter.data.remote.UserRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteModule {

    @Binds
    abstract fun provideUserRemote(userRemoteDataSource: UserRemoteDataSourceImpl): UserRemoteDataSource
}