package com.example.twitter.domain.usecase

import com.example.twitter.domain.repository.CredentialRepository
import com.example.twitter.domain.usecase.base.AbsUseCaseCompl
import io.reactivex.Completable
import javax.inject.Inject

class UpdateUserCredentialUseCase @Inject constructor(private val credentialRepository: CredentialRepository) : AbsUseCaseCompl<UpdateUserCredentialUseCase.Params>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return credentialRepository.updateUserCredential(params.id, params.name)
    }

    class Params(val id: Long, val name: String)
}