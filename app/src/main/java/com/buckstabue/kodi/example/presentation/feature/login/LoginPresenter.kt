package com.buckstabue.kodi.example.presentation.feature.login

import android.content.Context
import com.buckstabue.kodi.example.data.SessionGateway
import com.buckstabue.kodi.example.presentation.base.BasePresenter
import com.buckstabue.kodi.example.presentation.feature.profile.ProfileActivity

class LoginPresenter(
    private val sessionGateway: SessionGateway,
    context: Context
) : BasePresenter<LoginView>(context) {

    fun onLoginClicked(username: String, password: String) {
        sessionGateway.login(username, password)
        view?.openScreen(ProfileActivity.getStartIntent(context))
    }
}
