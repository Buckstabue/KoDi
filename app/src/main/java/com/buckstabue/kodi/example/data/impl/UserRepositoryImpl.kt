package com.buckstabue.kodi.example.data.impl

import com.buckstabue.kodi.example.data.UserRepository

class UserRepositoryImpl : UserRepository {
    override fun getUserName(): String {
        return "TestUser"
    }
}
