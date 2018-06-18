package com.example.twitter.android.di.module

import android.content.Context
import android.content.SharedPreferences
import com.example.twitter.android.di.qualifier.AppQualifier
import com.example.twitter.android.preference.SharedPreferenceProvider
import com.example.twitter.data.source.preference.AppSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@AppQualifier application: Context): SharedPreferences {
        return application.getSharedPreferences(application.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAppPreferences(sharedPreferences: SharedPreferences): AppSharedPreferences {
        return SharedPreferenceProvider(sharedPreferences)
    }

}