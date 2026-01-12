package com.example.bookstreak.auth

import androidx.lifecycle.ViewModel
import com.example.bookstreak.auth.domain.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {

    val _authState = MutableStateFlow<AuthState>(AuthState.Pending())
    val authState = _authState.asStateFlow()


    fun createAccount() {

    }

    fun passChanged(newPass: String) {

    }


    fun nameChanged(newPass: String) {

    }

    fun emailChanged(newPass: String) {

    }

}