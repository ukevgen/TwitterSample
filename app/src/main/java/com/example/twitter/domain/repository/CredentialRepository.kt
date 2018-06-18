package com.example.twitter.domain.repository

import com.example.twitter.domain.model.UserCredentials
import io.reactivex.Completable
import io.reactivex.Single

interface CredentialRepository {
    fun getUserCredential(): Single<UserCredentials>
    fun updateUserCredential(id: Long, name: String): Completable
//    fun updateUserCredential(id: Long, name: String, key: String, token: String): Completable
}