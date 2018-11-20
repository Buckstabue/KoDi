package com.buckstabue.kodi.example.data

interface SessionGateway {
    fun login(username: String, password: String)
    fun logout()
}
