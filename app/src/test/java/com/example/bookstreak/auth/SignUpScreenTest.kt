package com.example.bookstreak.auth

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.bookstreak.theme.BookStreakTheme
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class SignUpScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun emailField_whenUserTypes_callsOnEmailChange() {
        var capturedEmail = ""

        composeTestRule.setContent {
                AccountInfoInput(
                    email = "",
                    onEmailChange = { capturedEmail = it },
                    password = "",
                    onPasswordChange = {}
                )
        }

        composeTestRule.onNodeWithText("Enter your email").performTextInput("test@example.com")

        Assert.assertEquals("test@example.com", capturedEmail)
    }

    @Test
    fun passwordField_whenUserTypes_callsOnPasswordChange(){
        var capturedPass = ""


        composeTestRule.setContent {
            AccountInfoInput(
                email = "",
                onEmailChange = {},
                password = "",
                onPasswordChange = {capturedPass = it}
            )
        }

        composeTestRule.onNodeWithText("Enter your password").performTextInput("1234")

        Assert.assertEquals("1234", capturedPass)
    }
}