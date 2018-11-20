package com.buckstabue.kodi.example.data.impl

import com.buckstabue.kodi.example.AppInjector
import com.buckstabue.kodi.example.data.AppPreference
import com.buckstabue.kodi.example.data.SessionGateway

class SessionGatewayImpl(
    private val appPreference: AppPreference
) : SessionGateway {
    override fun login(username: String, password: String) {
        appPreference.currentUserId = username
    }

    override fun logout() {
        appPreference.currentUserId = null
        AppInjector.dropUserComponent()
    }
}
