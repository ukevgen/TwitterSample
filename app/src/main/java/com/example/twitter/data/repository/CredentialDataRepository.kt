package com.example.twitter.data.repository

import com.example.twitter.data.datasource.CredentialLocalDataSource
import com.example.twitter.domain.model.UserCredentials
import com.example.twitter.domain.repository.CredentialRepository
import io.reactivex.Single
import javax.inject.Inject

class CredentialDataRepository @Inject constructor(val localDataSource: CredentialLocalDataSource) : CredentialRepository {

    override fun getUserCredential(): Single<UserCredentials> {
        return localDataSource.getUserCredential()
    }
}