package com.example.dynamiccontent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dynamiccontent.ui.theme.DynamicContentTheme

private val namesList = mutableListOf(
    "Daniel",
    "Amy",
    "David",
    "Michael",
    "Tom",
    "John",
    "Andrew",
    "Shawn"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingList(names = namesList)
        }
    }
}

@Composable
fun GreetingList(names: MutableList<String>) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (name in names) {
            Greeting(name)
        }
        Button(onClick = { 
            names.add("New name")
        }) {
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
    GreetingList(names = namesList)
}