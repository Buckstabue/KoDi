package com.buckstabue.kodi.example.data.impl

import com.buckstabue.kodi.example.data.UserRepository

class UserRepositoryImpl(
    private val currentUserId: String
) : UserRepository {
    override fun getUserName(): String {
        return currentUserId
    }
}
