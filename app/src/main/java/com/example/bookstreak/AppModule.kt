package com.example.bookstreak

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookstreak.auth.AuthViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAuthViewModel() : AuthViewModel{
        return AuthViewModel()
    }
}