package com.example.bookstreak.auth.domain


enum class AuthState {    Pending,
    Success,
    Failed
}
enum class PasswordStrength(val value: Int, val label: String){
    Weak(0, "Weak"), Fair(1, "Fair"), Good(2, "Good"), Strong(3, "Strong"), VeryStrong(4, "Very strong");

    companion object {
        fun fromScore(score: Int) = entries.getOrElse(score) { Strong }
    }
}

// full name is optional because that field does not exist in login

data class AuthFormData(val fullName: String? = null, val email: String, val password: String, val passwordStrength: PasswordStrength = PasswordStrength.Weak)

