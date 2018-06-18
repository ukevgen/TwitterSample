package com.example.twitter.presentation.main

import com.example.twitter.domain.usecase.GetUserCredentialUseCase
import com.example.twitter.presentation.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(val getUserCredentialUseCase: GetUserCredentialUseCase) : BasePresenter<MainView>() {


}