package com.example.bookstreak.auth.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookstreak.auth.domain.AuthFormData
import com.example.bookstreak.auth.domain.AuthState
import com.example.bookstreak.theme.BookStreakTheme

@Composable
fun SignUpForm(
    formData: AuthFormData,
    onFullNameChanged: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = modifier) {
        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(
                text = "Full Name",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                placeholder = { Text("John Doe", fontWeight = FontWeight.Light) },
                value = formData.fullName ?: "",
                onValueChange = { onFullNameChanged(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down)}
                ),
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(
                text = "Email Address",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                placeholder = { Text("your@example.com", fontWeight = FontWeight.Light) },
                value = formData.email,
                onValueChange = { onEmailChange(it)},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down)}
                ),
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(
                text = "Password",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                placeholder = { Text("Enter your password", fontWeight = FontWeight.Light) },
                value = formData.password,
                onValueChange = { onPasswordChange(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onNext = {
                        keyboardController?.hide()
                        // TODO: add on submit
                    }
                ),
                shape = RoundedCornerShape(25),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
            )
        }
        PasswordStrengthMeter(3, "strong")
    }
}



@Preview(showBackground = true)
@Composable
fun AccountInfoInputPreview() {
    BookStreakTheme {
        SignUpForm(AuthFormData(email =  "",password =  ""), {}, {}, {})
    }
}
