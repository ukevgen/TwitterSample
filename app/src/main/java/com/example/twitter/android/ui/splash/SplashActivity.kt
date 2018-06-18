package com.example.twitter.android.ui.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.twitter.android.ui.BaseActivity
import com.example.twitter.presentation.splash.SplashPresenter
import com.example.twitter.presentation.splash.SplashView
import com.example.twitter.twitterapplication.R
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashView {

    @Inject lateinit var presenter: SplashPresenter

    override fun getActivityPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        btLogin.callback = object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>?) {
                Log.d("TWITTER", "$result")
            }

            override fun failure(exception: TwitterException?) {
                Log.d("TWITTER", "$exception")
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        btLogin.onActivityResult(requestCode, resultCode, data)
    }

}
