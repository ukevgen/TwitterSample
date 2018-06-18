package com.example.twitter.data.remote.retrofit.service

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface UserTimeLineService {

    @GET("statuses/user_timeline.json?screen_name=twitterapi")
    fun getUserTimeLine(@Query("user_id") userId: Long,
                        @Query("since_id") sinceId: Int
    ): Single<ResponseBody>
}