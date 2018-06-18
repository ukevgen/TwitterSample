package com.example.twitter.domain.usecase

import com.example.twitter.data.repository.UserDataRepository
import com.example.twitter.domain.usecase.base.AbsUseCaseCompl
import io.reactivex.Completable
import javax.inject.Inject

class GetUserTimeLineUseCase @Inject constructor(private val userDataRepository: UserDataRepository) : AbsUseCaseCompl<Unit>() {

    override fun buildUseCaseObservable(params: Unit): Completable {
        return userDataRepository.getUserTimeLine()
    }
}