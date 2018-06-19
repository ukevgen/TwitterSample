package com.example.twitter.android.ui.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import com.example.twitter.android.ui.BaseActivity
import com.example.twitter.domain.model.User
import com.example.twitter.presentation.main.MainPresenter
import com.example.twitter.presentation.main.MainView
import com.example.twitter.twitterapplication.R
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterCore
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.models.Tweet
import com.twitter.sdk.android.tweetcomposer.ComposerActivity
import com.twitter.sdk.android.tweetcomposer.TweetUploadService
import com.twitter.sdk.android.tweetui.TimelineResult
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter
import com.twitter.sdk.android.tweetui.UserTimeline
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView {


    @Inject lateinit var presenter: MainPresenter
    lateinit var adapter: TweetTimelineRecyclerViewAdapter


    var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when {
                TweetUploadService.UPLOAD_SUCCESS == intent.action -> (this@MainActivity as MainView).renderTwits()
                TweetUploadService.UPLOAD_FAILURE == intent.action -> {
                    toast(TweetUploadService.UPLOAD_FAILURE)
                }
                TweetUploadService.TWEET_COMPOSE_CANCEL == intent.action -> {
                    toast(TweetUploadService.TWEET_COMPOSE_CANCEL)
                }
            }
        }
    }

    val refreshListener = SwipeRefreshLayout.OnRefreshListener { renderTwits() }

    override fun getActivityPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        presenter.takeView(this)

        val successFilter = IntentFilter()
                .apply {
                    addAction(TweetUploadService.UPLOAD_SUCCESS)
                    addAction(TweetUploadService.UPLOAD_FAILURE)
                    addAction(TweetUploadService.TWEET_COMPOSE_CANCEL)
                }

        registerReceiver(broadcastReceiver, successFilter)

        btCreateTwit.setOnClickListener { renderCreateTwitActivity() }
        lSwipeAndRefresh.setOnRefreshListener(refreshListener)

    }

    override fun onDestroy() {
        unregisterReceiver(broadcastReceiver)
        super.onDestroy()
    }

    override fun renderUserTimeLine(user: User) {
        val userTimeline = UserTimeline.Builder()
                .userId(user.id)
                .screenName(user.name).build()

        adapter = TweetTimelineRecyclerViewAdapter.Builder(this)
                .setTimeline(userTimeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .build()

        recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recycler.adapter = adapter

    }

    override fun renderTitle(name: String) {
        supportActionBar?.title = name
    }

    override fun renderCreateTwitActivity() {
        val session = TwitterCore.getInstance().sessionManager
                .activeSession
        val intent = ComposerActivity.Builder(this)
                .session(session)
                .createIntent()
        startActivity(intent)
    }

    override fun renderTwits() {
        lSwipeAndRefresh.isRefreshing = true
        adapter.refresh(object : Callback<TimelineResult<Tweet>>() {
            override fun success(result: Result<TimelineResult<Tweet>>?) {
                lSwipeAndRefresh.isRefreshing = false
            }

            override fun failure(exception: TwitterException?) {
                toast(exception?.localizedMessage ?: "")
                lSwipeAndRefresh.isRefreshing = false
            }

        })
    }
}
