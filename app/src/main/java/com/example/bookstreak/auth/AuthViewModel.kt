package com.example.bookstreak.auth

import androidx.lifecycle.ViewModel
import com.example.bookstreak.auth.domain.AuthFormData
import com.example.bookstreak.auth.domain.AuthState
import com.example.bookstreak.auth.domain.PasswordStrength
import com.nulabinc.zxcvbn.Strength
import com.nulabinc.zxcvbn.Zxcvbn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class AuthViewModel : ViewModel() {

    private val _authFormData =
        MutableStateFlow<AuthFormData>(AuthFormData(email = "", password = ""))
    private val _authState = MutableStateFlow<AuthState>(AuthState.Pending)
    private val zxcvbn = Zxcvbn()
    val authFormData = _authFormData.asStateFlow()
    val authState = _authState.asStateFlow()


    fun createAccount() {

    }

    fun passChanged(newPass: String) {
        val strength = PasswordStrength.fromScore(zxcvbn.measure(newPass).score)
        _authFormData.update { it.copy(password = newPass, passwordStrength = strength) }
    }


    fun nameChanged(newName: String) {
        _authFormData.update { it.copy(fullName = newName) }
    }

    fun emailChanged(newEmail: String) {
        _authFormData.update { it.copy(email = newEmail) }
    }

}