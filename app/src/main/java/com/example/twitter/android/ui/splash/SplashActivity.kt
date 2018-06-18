package com.example.twitter.android.ui.splash

import android.content.Intent
import android.os.Bundle
import com.example.twitter.EmptyConstants
import com.example.twitter.android.ui.BaseActivity
import com.example.twitter.android.ui.main.MainActivity
import com.example.twitter.presentation.splash.SplashPresenter
import com.example.twitter.presentation.splash.SplashView
import com.example.twitter.twitterapplication.R
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject


class SplashActivity : BaseActivity(), SplashView {


    @Inject lateinit var presenter: SplashPresenter

    override fun getActivityPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter.takeView(this)

        btLogin.callback = object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>) {
                presenter.updateUserCredential(
                        result.data.userId,
                        result.data.userName ?: EmptyConstants.EMPTY_STRING
                )
            }

            override fun failure(exception: TwitterException?) {
                toast(exception?.message ?: exception?.localizedMessage ?: "")
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        btLogin.onActivityResult(requestCode, resultCode, data)
    }

    override fun renderMainActivity() {
        startActivity<MainActivity>()
    }

}
