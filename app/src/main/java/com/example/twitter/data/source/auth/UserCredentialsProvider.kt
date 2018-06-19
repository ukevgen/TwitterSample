package com.example.twitter.data.source.auth

import com.example.twitter.android.preference.SharedPreferenceProvider.Companion.KEY_SECRET_KEY
import com.example.twitter.android.preference.SharedPreferenceProvider.Companion.KEY_TOKEN_KEY
import com.example.twitter.android.preference.SharedPreferenceProvider.Companion.KEY_USER_ID
import com.example.twitter.android.preference.SharedPreferenceProvider.Companion.KEY_USER_NAME
import com.example.twitter.data.source.preference.AppSharedPreferences
import com.example.twitter.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.functions.Function4
import javax.inject.Inject

class UserCredentialsProvider @Inject constructor(private val preference: AppSharedPreferences) : UserAuthCredentials {

    override fun updateUserCredential(id: Long, name: String): Completable {
        return preference.putLong(KEY_USER_ID, id)
                .andThen(preference.putString(KEY_USER_NAME, name))
    }

//    override fun updateUser(id: Long, name: String, key: String, token: String): Completable {
//
//    }

    override fun getUserCredentials(): Single<User> {
        return Single.zip(
                preference.getString(KEY_USER_NAME),
                preference.getString(KEY_TOKEN_KEY),
                preference.getString(KEY_SECRET_KEY),
                preference.getLong(KEY_USER_ID),
                Function4<String, String, String, Long, User> { name, token, secret, id ->
                    User(id, name)
                }
        )
    }
}