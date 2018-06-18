package com.example.twitter.data.source.auth

import com.example.twitter.domain.model.UserCredentials
import io.reactivex.Single

interface UserAuthCredentials : AuthCredentials {
    fun getUserCredentials(): Single<UserCredentials>
}