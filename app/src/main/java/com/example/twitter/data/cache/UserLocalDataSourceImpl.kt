package com.example.twitter.data.cache

import com.example.twitter.data.datasource.UserLocalDataSource
import com.example.twitter.data.source.auth.UserCredentialsProvider
import com.example.twitter.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor(val credentialsProvider: UserCredentialsProvider) : UserLocalDataSource {

    override fun updateUser(id: Long, name: String): Completable {
        return credentialsProvider.updateUserCredential(id, name)
    }

//    override fun updateUser(id: Long, name: String, key: String, token: String): Completable {
//        return credentialsProvider.updateUser(id, name, key, token)
//    }

    override fun getUser(): Single<User> {
        return credentialsProvider.getUserCredentials()
    }
}