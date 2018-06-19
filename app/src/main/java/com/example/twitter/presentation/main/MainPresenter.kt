package com.example.twitter.presentation.main

import com.example.twitter.domain.model.UserCredentials
import com.example.twitter.domain.usecase.GetUserCredentialUseCase
import com.example.twitter.presentation.BasePresenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class MainPresenter @Inject constructor(val getUserCredentialUseCase: GetUserCredentialUseCase) : BasePresenter<MainView>() {

    override fun onTakeView(view: MainView) {
        super.onTakeView(view)
        subscribeToTweets()
    }

    override fun onDropView() {
        getUserCredentialUseCase.dispose()
        super.onDropView()
    }

    private fun subscribeToTweets() {
        getUserCredentialUseCase.execute(object : DisposableSingleObserver<UserCredentials>() {
            override fun onSuccess(user: UserCredentials) {
                view?.renderUserTimeLine(user)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        }, Unit)
    }
}