package com.example.bookstreak.auth.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookstreak.auth.AuthViewModel
import com.example.bookstreak.auth.domain.AuthFormData
import com.example.bookstreak.theme.BookStreakTheme


@Composable
fun SignUpScreen(modifier: Modifier = Modifier, vm: AuthViewModel) {
    // Header text
    val authState by vm.authState.collectAsStateWithLifecycle()
    val formData by vm.authFormData.collectAsStateWithLifecycle()
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .padding(horizontal = 20.dp)
    ) {
        Spacer(Modifier.height(70.dp))
        // heading  and icon
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "\uD83C\uDF31", fontSize = 50.sp)
            Text(
                text = "Create Your Account",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
            Text("Start your reading streak today", style = MaterialTheme.typography.bodyLarge)
        }

        // TODO: add terms of service checkbox

        SignUpForm(
            formData = formData,
            onFullNameChanged = vm::nameChanged,
            onEmailChange = vm::emailChanged,
            onPasswordChange = vm::passChanged,
        )
        Row(verticalAlignment = Alignment.CenterVertically ){
            Checkbox(checked = false, onCheckedChange = {it})
            Text("Accept non existent terms and conditions", style = MaterialTheme.typography.labelLarge)
        }

        CreateAccountBtn(
            onCreateAccount = vm::createAccount,
            modifier = Modifier.fillMaxWidth()
        )

        OtherOptionsSection()

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    val authViewModel: AuthViewModel = viewModel()
    BookStreakTheme {
        SignUpScreen(vm = authViewModel)
    }
}