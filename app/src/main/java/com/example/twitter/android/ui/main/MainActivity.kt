package com.example.twitter.android.ui.main

import android.os.Bundle
import com.example.twitter.android.ui.BaseActivity
import com.example.twitter.presentation.main.MainPresenter
import com.example.twitter.presentation.main.MainView
import com.example.twitter.twitterapplication.R
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView {

    @Inject lateinit var presenter: MainPresenter

    override fun getActivityPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }


}
