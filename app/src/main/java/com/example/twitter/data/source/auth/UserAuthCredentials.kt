package com.example.twitter.data.source.auth

import com.example.twitter.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UserAuthCredentials : AuthCredentials {
    fun getUserCredentials(): Single<User>
    //    fun updateUser(id: Long, name: String, key: String, token: String): Completable
    fun updateUserCredential(id: Long, name: String): Completable
}