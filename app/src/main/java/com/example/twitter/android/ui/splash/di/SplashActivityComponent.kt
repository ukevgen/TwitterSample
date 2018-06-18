package com.example.twitter.android.ui.splash.di

import android.support.v7.app.AppCompatActivity
import com.example.twitter.android.di.scopes.PerActivity
import com.example.twitter.android.ui.splash.SplashActivity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector


@PerActivity
@Subcomponent(modules = [
    (SplashActivityComponent.ActivityBindsModule::class),
    (SplashActivityComponent.FragmentBindingsModule::class),
    (SplashActivityComponent.ActivityModule::class),
    (SplashActivityComponent.BindingsModule::class)
])
interface SplashActivityComponent : AndroidInjector<SplashActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SplashActivity>()

    @Module
    interface ActivityBindsModule {

        @Binds
        fun provideActivityModule(activity: SplashActivity): AppCompatActivity

    }

    @Module
    class ActivityModule {

    }

    @Module(subcomponents = [

    ])
    interface FragmentBindingsModule {

    }

    @Module
    interface BindingsModule {

    }


}