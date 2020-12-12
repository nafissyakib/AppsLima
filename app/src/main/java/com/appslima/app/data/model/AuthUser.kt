package com.appslima.app.data.model

data class AuthUser(
        val id: Int = 0,
        val email: String = "",
        val password: String = "",
        val fullname: String = "",
        val fullName: String?
)