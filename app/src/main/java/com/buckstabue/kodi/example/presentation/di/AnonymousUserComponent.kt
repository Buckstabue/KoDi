package com.buckstabue.kodi.example.presentation.di

import com.buckstabue.kodi.core.Component
import com.buckstabue.kodi.dsl.component
import com.buckstabue.kodi.example.data.SessionGateway
import com.buckstabue.kodi.example.data.impl.SessionGatewayImpl

fun createAnonymousUserComponent(appComponent: Component): Component {
    return component(parent = appComponent) {
        single<SessionGateway> { SessionGatewayImpl() }
    }
}
