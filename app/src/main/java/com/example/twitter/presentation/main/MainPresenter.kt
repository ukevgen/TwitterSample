package com.example.twitter.presentation.main

import com.example.twitter.domain.model.User
import com.example.twitter.domain.usecase.GetUserUseCase
import com.example.twitter.presentation.BasePresenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class MainPresenter @Inject constructor(val getUserCredentialUseCase: GetUserUseCase) : BasePresenter<MainView>() {

    override fun onTakeView(view: MainView) {
        super.onTakeView(view)
        subscribeToTweets()
    }

    override fun onDropView() {
        getUserCredentialUseCase.dispose()
        super.onDropView()
    }

    private fun subscribeToTweets() {
        getUserCredentialUseCase.execute(object : DisposableSingleObserver<User>() {
            override fun onSuccess(user: User) {
                view?.renderUserTimeLine(user)
                view?.renderTitle(user.name)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        }, Unit)
    }
}