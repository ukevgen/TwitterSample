package com.example.twitter.presentation.main

import com.example.twitter.domain.usecase.GetUserTimeLineUseCase
import com.example.twitter.presentation.BasePresenter
import com.google.gson.annotations.Until
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

class MainPresenter @Inject constructor(val getUserTimeLineUseCase: GetUserTimeLineUseCase) : BasePresenter<MainView>() {

    override fun onTakeView(view: MainView) {
        super.onTakeView(view)

     getUserTimeLineUseCase.execute(object : DisposableCompletableObserver() {
         override fun onComplete() {
             TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
         }

         override fun onError(e: Throwable) {
             e.printStackTrace()
         }
     }, Unit)
    }

    override fun onDropView() {
        getUserTimeLineUseCase.dispose()
        super.onDropView()
    }

}