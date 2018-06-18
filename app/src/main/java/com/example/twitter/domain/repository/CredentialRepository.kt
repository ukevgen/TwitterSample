package com.example.twitter.domain.repository

import com.example.twitter.domain.model.UserCredentials
import io.reactivex.Single

interface CredentialRepository {
    fun getUserCredential(): Single<UserCredentials>
}