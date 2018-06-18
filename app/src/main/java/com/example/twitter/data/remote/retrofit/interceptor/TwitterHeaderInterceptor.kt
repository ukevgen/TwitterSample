package com.example.twitter.data.remote.retrofit.interceptor

import com.twitter.sdk.android.core.TwitterCore
import com.twitter.sdk.android.core.internal.network.OAuth1aInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TwitterHeaderInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val session = TwitterCore.getInstance().sessionManager.activeSession
        val auth = TwitterCore.getInstance().authConfig
        return OAuth1aInterceptor(session, auth).intercept(chain)
    }
}