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
        Row {
            ColoredSurface(color = Color.Blue)
            ColoredSurface(color = Color.White)
            ColoredSurface(color = Color.Red)
            ColoredSurface(color = Color.Green)
            ColoredSurface(color = Color.Green)
            ColoredSurface(color = Color.Green)
        }
    }
}

@Composable
fun ColoredSurface(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .width(50.dp)
            .fillMaxHeight()
    ) {}
}

// @Composable 어노테이션을 통해 이 함수가 UI의 일부분임을 알려준다
@Composable
fun GreetingText(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            /** Modifier -> 아래서 위로 적용된다!!! */
            .fillMaxSize()
            .fillMaxSize() // 안에 매개변수를 넣어 비율 조정 가능
            .padding(24.dp)
            .clickable {
                // 클릭 시 이벤트
            },
        style = MaterialTheme.typography.h3,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSimpleTextTheme {
        MainScreen()
    }
}