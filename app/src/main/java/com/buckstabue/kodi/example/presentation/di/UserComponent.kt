package com.buckstabue.kodi.example.presentation.di

import com.buckstabue.kodi.core.Component
import com.buckstabue.kodi.dsl.component
import com.buckstabue.kodi.example.data.AppPreference
import com.buckstabue.kodi.example.presentation.di.qualifier.CurrentUserId

@Suppress("RemoveExplicitTypeArguments")
fun createUserComponent(appComponent: Component): Component {
    val appPreference = appComponent.get<AppPreference>()
    val userId = appPreference.currentUserId!!
    return component(parent = appComponent) {
        single<Long>(CurrentUserId) { userId }
    }
}
