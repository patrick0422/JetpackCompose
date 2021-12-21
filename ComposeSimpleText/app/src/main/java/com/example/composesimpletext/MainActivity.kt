package com.example.composesimpletext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesimpletext.ui.theme.ComposeSimpleTextTheme

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
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ColoredSurface(color = Color.Blue)
            ColoredSurface(color = Color.White)
            ColoredSurface(color = Color.Red)
            ColoredSurface(color = Color.Blue)
            ColoredSurface(color = Color.White)
            ColoredSurface(color = Color.Red)
        }
    }
}

@Composable
fun ColoredSurface(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .width(30.dp)
            .fillMaxHeight()
    ) {}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSimpleTextTheme {
        MainScreen()
    }
}