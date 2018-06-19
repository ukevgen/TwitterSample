package com.example.twitter.data.datasource

import com.example.twitter.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UserLocalDataSource {
    fun getUser(): Single<User>
    fun updateUser(id: Long, name: String): Completable
}