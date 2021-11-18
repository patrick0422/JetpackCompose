package com.example.composesimpletext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composesimpletext.ui.theme.ComposeSimpleTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Android")
        }
    }
}

// @Composable 어노테이션을 통해 이 함수가 UI의 일부분임을 알려준다
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

/**
@Preview 어노테이션을 통해 Preview 화면을 생성한다.
Preview 화면의 내용은 @Preview 함수 안의 내용을 표시하기 때문에,
실제 빌드 시 보이는 화면을 보기 위해서는 액티비티 안의 setContent 함수의 내용과 같게 해 주어야 한다.
*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSimpleTextTheme {
        Greeting("Android")
    }
}