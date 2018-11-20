package com.buckstabue.kodi.example.presentation.feature.profile

import android.content.Context
import com.buckstabue.kodi.example.data.SessionGateway
import com.buckstabue.kodi.example.data.UserRepository
import com.buckstabue.kodi.example.presentation.base.BasePresenter
import com.buckstabue.kodi.example.presentation.feature.login.LoginActivity

class ProfilePresenter(
    private val sessionGateway: SessionGateway,
    private val userRepository: UserRepository,
    context: Context
) : BasePresenter<ProfileView>(context) {

    override fun onFirstViewAttach() {
        val userName = userRepository.getUserName()
        view?.showUserName(userName)
    }

    fun onLogoutClick() {
        sessionGateway.logout()
        view?.openScreen(LoginActivity.getStartIntent(context))
    }
}
