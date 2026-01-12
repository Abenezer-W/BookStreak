package com.example.bookstreak.auth.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookstreak.theme.BookStreakTheme


@Composable
fun CreateAccountBtn(onCreateAccount: () -> Unit, modifier: Modifier = Modifier){
    Button(onClick = {onCreateAccount}, modifier ) {
        Text("Create Account", style = MaterialTheme.typography.titleMedium,modifier =  Modifier.padding(vertical = 5.dp))
    }
}

@Composable
fun OtherOptionsSection(modifier: Modifier = Modifier){

}


@Preview(showBackground = true)
@Composable
fun CreateAccountBtnPreview(){
    BookStreakTheme {
        CreateAccountBtn(onCreateAccount = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOtherOptions(){
    BookStreakTheme {
        OtherOptionsSection()
    }
}