package com.example.jetpacknavigationcomponent

class UserLoginInfo {
    companion object {
        var user: User? = null
    }
}

data class User(val username: String, val password: String)