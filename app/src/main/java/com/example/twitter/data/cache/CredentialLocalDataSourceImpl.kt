package com.example.twitter.data.cache

import com.example.twitter.data.datasource.CredentialLocalDataSource
import com.example.twitter.data.source.auth.UserCredentialsProvider
import com.example.twitter.domain.model.UserCredentials
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class CredentialLocalDataSourceImpl @Inject constructor(val credentialsProvider: UserCredentialsProvider) : CredentialLocalDataSource {

    override fun updateUserCredential(id: Long, name: String): Completable {
        return credentialsProvider.updateUserCredential(id, name)
    }

//    override fun updateUserCredential(id: Long, name: String, key: String, token: String): Completable {
//        return credentialsProvider.updateUserCredential(id, name, key, token)
//    }

    override fun getUserCredential(): Single<UserCredentials> {
        return credentialsProvider.getUserCredentials()
    }
}