package com.example.bookstreak.auth.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookstreak.auth.domain.PasswordStrength
import com.example.bookstreak.theme.BookStreakTheme

@Composable
fun PasswordStrengthMeter(passwordStrength: PasswordStrength, modifier: Modifier = Modifier) {
    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            repeat(4) { idx ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .background(
                            color = if (idx < passwordStrength.value) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.surfaceContainer,
                            shape = RoundedCornerShape(2.dp)
                        )
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = passwordStrength.label,
            style = MaterialTheme.typography.bodySmall
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPasswordStrengthMeter(){
    BookStreakTheme {
        PasswordStrengthMeter(PasswordStrength.Weak)
    }
}