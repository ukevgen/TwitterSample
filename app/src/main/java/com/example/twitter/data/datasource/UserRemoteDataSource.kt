package com.example.twitter.data.datasource

import io.reactivex.Completable

interface UserRemoteDataSource {
    fun getUserTimeLine() : Completable
}