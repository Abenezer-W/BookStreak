package com.example.bookstreak.auth

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookstreak.theme.BookStreakTheme


@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    // Header text
    val email = remember { mutableStateOf("") }
    val pass = remember {mutableStateOf("")}
    Column {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 12.dp)
        ) {
            Text(text = "Create Your Account", style = MaterialTheme.typography.titleMedium)
        }

        AccountInfoInput(email.value, { email.value = it }, pass.value, {pass.value = it},modifier.padding(start = 22.dp))
    }

}

@Composable
fun AccountInfoInput(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.spacedBy(26.dp), modifier = modifier) {
        Column(verticalArrangement = Arrangement.spacedBy(11.dp)) {
            Text(text = "Email Address", style = MaterialTheme.typography.labelMedium, modifier =  Modifier.fillMaxWidth())
            OutlinedTextField(
                placeholder = { Text("Enter your email") },
                value = email,
                onValueChange = { onEmailChange(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                shape = RoundedCornerShape(50),
                modifier = Modifier.height(52.dp)
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(11.dp)) {
            Text(text = "Password", style = MaterialTheme.typography.labelMedium, modifier =  Modifier.fillMaxWidth())
            OutlinedTextField(
                placeholder = { Text("Enter your password") },
                value = password,
                onValueChange = { onPasswordChange(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(50),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.height(52.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    BookStreakTheme {
        SignUpScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun AccountInfoInputPreview() {
    BookStreakTheme {
        AccountInfoInput("", { it }, "", {it})
    }
}
