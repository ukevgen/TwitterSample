package com.example.twitter.domain.usecase

import com.example.twitter.data.repository.UserDataRepository
import com.example.twitter.domain.model.User
import com.example.twitter.domain.usecase.base.AbsUseCaseSingle
import io.reactivex.Single
import javax.inject.Inject

class GetUserUseCase @Inject constructor(val userDataRepository: UserDataRepository) : AbsUseCaseSingle<User, Unit>() {

    override fun buildUseCaseObservable(params: Unit): Single<User> {
        return userDataRepository.getUser()
    }
}