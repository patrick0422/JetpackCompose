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
            Greeting("Student")

            // Text 함수도 Composable 기반이기 때문에 바로 setContent 안에 넣어도 작동
//            Text(text = "Hello $name!")
        }
    }
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
        Greeting("Student")
    }
}