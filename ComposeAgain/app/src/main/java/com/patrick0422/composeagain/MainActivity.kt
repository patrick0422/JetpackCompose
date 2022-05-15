package com.patrick0422.composeagain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patrick0422.composeagain.ui.theme.ComposeAgainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAgainTheme {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        MyBody(Modifier.padding(innerPadding))
    }
}

@Composable
fun MyBody(modifier: Modifier) {

}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    ComposeAgainTheme {
        MyApp()
    }
}