package com.example.twitter.data.source.auth.di

import com.example.twitter.data.source.auth.UserAuthCredentials
import com.example.twitter.data.source.auth.UserCredentialsProvider
import com.example.twitter.data.source.preference.AppSharedPreferences
import dagger.Module
import dagger.Provides

@Module
class AuthModule {

    @Provides
    fun provideUserCredentials(preferences: AppSharedPreferences): UserAuthCredentials = UserCredentialsProvider(preferences)
}