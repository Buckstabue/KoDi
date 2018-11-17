package com.buckstabue.kodi.example

import com.buckstabue.kodi.core.Component
import com.buckstabue.kodi.core.ComponentProvider
import com.buckstabue.kodi.example.presentation.di.createAnonymousUserComponent
import com.buckstabue.kodi.example.presentation.di.createAppComponent
import com.buckstabue.kodi.example.presentation.di.createUserComponent

object AppInjector {
    private val appComponentProvider = ComponentProvider { createAppComponent(App.context) }
    private val anonymousComponentProvider = ComponentProvider { createAnonymousUserComponent(appComponent) }
    private val userComponentProvider = ComponentProvider { createUserComponent(appComponent) }

    val appComponent: Component
        get() = appComponentProvider.provideComponent()

    fun getUserComponent(): Component {
        return userComponentProvider.provideComponent()
    }

    fun getAnonymousUserComponent(): Component {
        return anonymousComponentProvider.provideComponent()
    }

    fun dropUserComponent() {
        userComponentProvider.resetComponent()
    }

    fun dropAnonymousUserComponent() {
        anonymousComponentProvider.resetComponent()
    }

    fun dropAppComponent() {
        appComponentProvider.resetComponent()
    }
}
