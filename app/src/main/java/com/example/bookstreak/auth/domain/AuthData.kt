package com.example.bookstreak.auth.domain


sealed class AuthState {
    data class Pending(val authData: AuthData = AuthData("", "", "")) : AuthState()
    data class Failed(val authData: AuthData) : AuthState()
    data class Success(val authData: AuthData) : AuthState()

}

// full name is optional because that field does not exist in login
data class AuthData(val fullName: String?, val email: String, val pass: String)