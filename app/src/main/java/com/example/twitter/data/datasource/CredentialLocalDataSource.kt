package com.example.twitter.data.datasource

import com.example.twitter.domain.model.UserCredentials
import io.reactivex.Completable
import io.reactivex.Single

interface CredentialLocalDataSource {
    fun getUserCredential(): Single<UserCredentials>
    //    fun updateUserCredential(id: Long, name: String, key: String, token: String): Completable
    fun updateUserCredential(id: Long, name: String): Completable
}