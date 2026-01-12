package com.example.bookstreak.auth.ui

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookstreak.R
import com.example.bookstreak.theme.BookStreakTheme


@Composable
fun CreateAccountBtn(onCreateAccount: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = { onCreateAccount }, modifier) {
        Text(
            "Create Account",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 5.dp)
        )
    }
}

@Composable
fun OtherOptionsSection(modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
            HorizontalDivider(modifier = modifier.weight(1f))
            Text("or sign up with", style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.outline,
                modifier = modifier.padding(horizontal = 10.dp))
            HorizontalDivider(modifier = modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(28.dp))
        Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)){
            OutlinedIconButton(
                onClick = {},
                shape = RoundedCornerShape(30),
                border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier.weight(1f).height(64.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icons8_google),
                    contentDescription = "google icon",
                    modifier = Modifier.size(32.dp)
                )
            }
            OutlinedIconButton(
                onClick = {},
                shape = RoundedCornerShape(30),
                border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier.weight(1f).height(64.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icons8_apple),
                    contentDescription = "google icon",
                    modifier = Modifier.size(32.dp)
                )
            }
            OutlinedIconButton(
                onClick = {},
                shape = RoundedCornerShape(30),
                border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier.weight(1f).height(64.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icons8_github_logo_30),
                    contentDescription = "google icon",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CreateAccountBtnPreview() {
    BookStreakTheme {
        CreateAccountBtn(onCreateAccount = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOtherOptions() {
    BookStreakTheme {
        OtherOptionsSection()
    }
}