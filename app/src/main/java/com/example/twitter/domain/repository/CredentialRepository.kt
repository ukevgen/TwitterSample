package com.example.twitter.domain.repository

import com.example.twitter.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface CredentialRepository {
    fun getUserCredential(): Single<User>
    fun updateUserCredential(id: Long, name: String): Completable
}