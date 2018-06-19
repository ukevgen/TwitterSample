package com.example.twitter.presentation.splash

import com.example.twitter.domain.usecase.UpdateUserUseCase
import com.example.twitter.presentation.BasePresenter
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

class SplashPresenter @Inject constructor(val updateUserUseCase: UpdateUserUseCase) : BasePresenter<SplashView>() {



    override fun onDropView() {
        updateUserUseCase.dispose()
        super.onDropView()
    }

    fun updateUserCredential(userId: Long, userName: String) {
        updateUserUseCase.execute(object : DisposableCompletableObserver() {
            override fun onComplete() {
                view?.renderMainActivity()
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        }, UpdateUserUseCase.Params(userId, userName))
    }

}