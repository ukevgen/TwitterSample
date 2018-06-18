package com.example.twitter.data.cache

import com.example.twitter.data.datasource.CredentialLocalDataSource
import com.example.twitter.data.source.auth.UserCredentialsProvider
import com.example.twitter.domain.model.UserCredentials
import io.reactivex.Single
import javax.inject.Inject

class CredentialLocalDataSourceImpl @Inject constructor(val credentialsProvider: UserCredentialsProvider) : CredentialLocalDataSource {
    override fun getUserCredential(): Single<UserCredentials> {
        return credentialsProvider.getUserCredentials()
    }
}