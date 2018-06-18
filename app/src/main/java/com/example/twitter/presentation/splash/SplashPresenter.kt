package com.example.twitter.presentation.splash

import com.example.twitter.domain.usecase.UpdateUserCredentialUseCase
import com.example.twitter.presentation.BasePresenter
import com.example.twitter.presentation.Presenter
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

class SplashPresenter @Inject constructor(val updateUserCredentialUseCase: UpdateUserCredentialUseCase) : BasePresenter<SplashView>() {



    override fun onDropView() {
        updateUserCredentialUseCase.dispose()
        super.onDropView()
    }

    fun updateUserCredential(userId: Long, userName: String) {
        updateUserCredentialUseCase.execute(object : DisposableCompletableObserver() {
            override fun onComplete() {
                view?.renderMainActivity()
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        }, UpdateUserCredentialUseCase.Params(userId, userName))
    }

}