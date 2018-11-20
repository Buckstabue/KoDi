package com.buckstabue.kodi.example.presentation.feature.login

import com.buckstabue.kodi.core.Component
import com.buckstabue.kodi.dsl.component
import com.buckstabue.kodi.example.AppInjector

fun createLoginComponent(): Component {
    return component(AppInjector.getAnonymousUserComponent()) {
        single<LoginPresenter> { LoginPresenter(get(), get()) }
    }
}
