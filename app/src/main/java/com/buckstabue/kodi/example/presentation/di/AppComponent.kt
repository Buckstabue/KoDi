package com.buckstabue.kodi.example.presentation.di

import com.buckstabue.kodi.dsl.component
import com.buckstabue.kodi.example.App
import com.buckstabue.kodi.example.data.AppPreference
import com.buckstabue.kodi.example.data.impl.AppPreferenceImpl


val appComponent = component {
    single<AppPreference> { AppPreferenceImpl() }
    single { App.context }
}
