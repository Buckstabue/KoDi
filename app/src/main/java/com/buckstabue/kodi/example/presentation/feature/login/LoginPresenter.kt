package com.buckstabue.kodi.example.presentation.feature.login

import com.buckstabue.kodi.example.data.SessionGateway

class LoginPresenter(
    private val sessionGateway: SessionGateway
) {
    fun onLoginClicked() {
        sessionGateway.login()
    }
}
