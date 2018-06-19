package com.example.twitter.data.remote

import com.example.twitter.data.datasource.UserRemoteDataSource
import com.example.twitter.data.remote.retrofit.service.UserTimeLineService
import com.example.twitter.data.source.auth.UserCredentialsProvider
import io.reactivex.Completable
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(private val userTimeLineService: UserTimeLineService,
                                                   private val credentialsProvider: UserCredentialsProvider
) : UserRemoteDataSource {
    override fun getUserTimeLine(): Completable {
        return credentialsProvider.getUserCredentials()
                .flatMapCompletable { userCredentials ->
                    userTimeLineService.getUserTimeLine(userCredentials.id, 500, userCredentials.name)
                            .toCompletable()

                }
    }
}