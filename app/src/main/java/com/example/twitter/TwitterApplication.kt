package com.example.twitter

import android.app.Activity
import android.app.Application
import android.app.Service
import android.support.v4.app.Fragment
import android.util.Log
import com.example.twitter.android.di.component.app.DaggerApplicationComponent
import com.example.twitter.android.di.module.ApplicationModule
import com.example.twitter.twitterapplication.R
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import dagger.android.support.HasSupportFragmentInjector
import io.realm.Realm
import javax.inject.Inject


class TwitterApplication : Application(), HasActivityInjector, HasSupportFragmentInjector, HasServiceInjector {

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var serviceInjector: DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .create(this)
                .inject(this)

        Realm.init(this)

        val config = TwitterConfig.Builder(this)
                .logger(DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(TwitterAuthConfig(
                        resources.getString(R.string.consumer_key),
                        resources.getString(R.string.consumer_secret)))
                .debug(true)
                .build()
        Twitter.initialize(config)


    }

    override fun activityInjector() = androidInjector
    override fun supportFragmentInjector() = fragmentInjector
    override fun serviceInjector() = serviceInjector
}