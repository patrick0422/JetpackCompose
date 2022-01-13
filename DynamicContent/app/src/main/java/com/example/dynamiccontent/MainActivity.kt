package com.example.dynamiccontent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
    }
}

@Composable
fun MainScreen() {
    val namesState = remember { mutableStateListOf("John", "Amanda") }
    val newNameStateContent = remember { mutableStateOf("") }

    GreetingList(
        namesState,
        newNameStateContent.value,
        { namesState.add(newNameStateContent.value) },
        { newName -> newNameStateContent.value = newName }
    )
}

@Composable
fun GreetingList(
    names: List<String>,
    textFieldValue: String,
    buttonClick: () -> Unit,
    textFieldUpdate: (newName: String) -> Unit) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (name in names) {
            Greeting(name)
        }


        TextField(value = textFieldValue, onValueChange = { newInput ->
            textFieldUpdate(newInput)
        })

        Button(onClick = buttonClick) {
            Text(text = "Add new name")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}