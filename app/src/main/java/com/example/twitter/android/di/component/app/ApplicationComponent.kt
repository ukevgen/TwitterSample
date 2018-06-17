package com.example.twitter.android.di.component.app

import android.app.Activity
import com.example.twitter.android.ui.main.di.MainActivityComponent
import com.example.twitter.TwitterApplication
import com.example.twitter.android.di.module.ApplicationModule
import com.example.twitter.android.ui.main.MainActivity
import com.example.twitter.data.cache.di.CacheModule
import com.example.twitter.data.cache.realm.dao.di.DaoRealmModule
import com.example.twitter.data.di.DataModule
import com.example.twitter.data.remote.di.RemoteModule
import com.example.twitter.data.remote.retrofit.di.NetModule
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (ApplicationModule::class),
    (DaoRealmModule::class),
    (DataModule::class),
    (CacheModule::class),
    (NetModule::class),
    (RemoteModule::class),
    (AndroidSupportInjectionModule::class),
    (ApplicationComponent.ActivityBindingsModule::class),
    (ApplicationComponent.FragmentBindingsModule::class),
    (ApplicationComponent.ServiceBindingsModule::class)
])
interface ApplicationComponent : AndroidInjector<TwitterApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TwitterApplication>() {
        abstract fun applicationModule(module: ApplicationModule): Builder
    }

    @Module(subcomponents = [
        (MainActivityComponent::class)
    ])
    interface ActivityBindingsModule {

        @Binds
        @IntoMap
        @ActivityKey(value = MainActivity::class)
        fun mainActivityComponentBuilder(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    }

    @Module(subcomponents = [

    ])
    interface FragmentBindingsModule {

    }

    @Module(subcomponents = [

    ])
    interface ServiceBindingsModule {

    }
}