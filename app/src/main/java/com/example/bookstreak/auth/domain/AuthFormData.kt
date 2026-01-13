package com.example.bookstreak.auth.domain


enum class AuthState {    Pending,
    Success,
    Failed
}
enum class PasswordStrength{

}

// full name is optional because that field does not exist in login

data class AuthFormData(val fullName: String? = null, val email: String, val password: String)

