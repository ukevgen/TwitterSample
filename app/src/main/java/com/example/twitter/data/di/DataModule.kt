package com.example.twitter.data.di

import com.example.twitter.data.repository.UserDataRepository
import com.example.twitter.domain.repository.CredentialRepository
import com.example.twitter.domain.repository.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {


    @Binds
    abstract fun provideUserRepository(repository: UserDataRepository): UserRepository

}