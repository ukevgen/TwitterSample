package com.example.twitter.domain.repository

import com.example.twitter.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UserRepository {
    fun getUserTimeLine() : Completable
    fun getUser(): Single<User>
    fun updateUser(id: Long, name: String): Completable
}