package com.example.twitter.domain.usecase

import com.example.twitter.domain.model.UserCredentials
import com.example.twitter.domain.repository.CredentialRepository
import com.example.twitter.domain.usecase.base.AbsUseCaseSingle
import io.reactivex.Single
import javax.inject.Inject

class GetUserCredentialUseCase @Inject constructor(val credentialDataRepository: CredentialRepository) : AbsUseCaseSingle<UserCredentials, Unit>() {

    override fun buildUseCaseObservable(params: Unit): Single<UserCredentials> {
        return credentialDataRepository.getUserCredential()
    }
}