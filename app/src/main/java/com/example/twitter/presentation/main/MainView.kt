package com.example.twitter.presentation.main

import com.example.twitter.domain.model.User
import com.example.twitter.presentation.PresenterView

interface MainView : PresenterView {
    fun renderUserTimeLine(user: User)
    fun renderTitle(name: String)
    fun renderCreateTwitActivity()
    fun renderTwits()
}