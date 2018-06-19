package com.example.twitter.presentation.main

import com.example.twitter.domain.model.UserCredentials
import com.example.twitter.presentation.PresenterView

interface MainView : PresenterView {
    fun renderUserTimeLine(user: UserCredentials)
    fun renderTitle(name: String)
    fun renderCreateTwitActivity()
    fun renderTwits()
}