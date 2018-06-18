package com.example.twitter.data.datasource

import com.example.twitter.domain.model.UserCredentials
import io.reactivex.Single

interface CredentialLocalDataSource {
    fun getUserCredential(): Single<UserCredentials>
}