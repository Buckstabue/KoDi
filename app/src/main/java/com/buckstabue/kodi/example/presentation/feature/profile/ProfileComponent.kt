package com.buckstabue.kodi.example.presentation.feature.profile

import com.buckstabue.kodi.core.Component
import com.buckstabue.kodi.dsl.component
import com.buckstabue.kodi.example.AppInjector

fun createProfileComponent(): Component {
    return component(AppInjector.getUserComponent()) {
        single<ProfilePresenter> { ProfilePresenter(get(), get(), get()) }
    }
}
