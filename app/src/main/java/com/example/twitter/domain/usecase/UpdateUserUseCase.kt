package com.example.twitter.domain.usecase

import com.example.twitter.data.repository.UserDataRepository
import com.example.twitter.domain.usecase.base.AbsUseCaseCompl
import io.reactivex.Completable
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(private val userDataRepository: UserDataRepository) : AbsUseCaseCompl<UpdateUserUseCase.Params>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return userDataRepository.updateUser(params.id, params.name)
    }

    class Params(val id: Long, val name: String)
}