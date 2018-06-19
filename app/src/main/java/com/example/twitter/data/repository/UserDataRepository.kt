package com.example.twitter.data.repository

import com.example.twitter.data.datasource.UserLocalDataSource
import com.example.twitter.data.datasource.UserRemoteDataSource
import com.example.twitter.domain.model.User
import com.example.twitter.domain.repository.UserRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UserDataRepository @Inject constructor(private val remoteDataSource: UserRemoteDataSource,
                                             private val localDataSource: UserLocalDataSource) : UserRepository {

    override fun getUserTimeLine(): Completable {
        return remoteDataSource.getUserTimeLine()
    }

    override fun updateUser(id: Long, name: String): Completable {
        return localDataSource.updateUser(id, name)
    }

    override fun getUser(): Single<User> {
        return localDataSource.getUser()
    }

}