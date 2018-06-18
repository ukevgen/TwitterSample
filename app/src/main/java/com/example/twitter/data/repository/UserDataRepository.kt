package com.example.twitter.data.repository

import com.example.twitter.data.datasource.UserRemoteDataSource
import com.example.twitter.domain.repository.UserRepository
import io.reactivex.Completable
import javax.inject.Inject

class UserDataRepository @Inject constructor(private val remoteDataSource: UserRemoteDataSource) : UserRepository {

    override fun getUserTimeLine(): Completable {
        return remoteDataSource.getUserTimeLine()
    }

}