package com.example.twitter.domain.repository

import io.reactivex.Completable

interface UserRepository {
    fun getUserTimeLine() : Completable
}