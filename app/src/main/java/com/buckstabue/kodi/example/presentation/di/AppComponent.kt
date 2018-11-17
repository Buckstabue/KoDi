package com.buckstabue.kodi.example.presentation.di

import android.content.Context
import com.buckstabue.kodi.core.Component
import com.buckstabue.kodi.dsl.component
import com.buckstabue.kodi.example.data.AppPreference
import com.buckstabue.kodi.example.data.impl.AppPreferenceImpl

@Suppress("RemoveExplicitTypeArguments")
fun createAppComponent(context: Context): Component {
    return component {
        single<AppPreference> { AppPreferenceImpl() }
        single<Context> { context }
    }
}

