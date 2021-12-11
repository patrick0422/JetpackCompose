package com.example.composesimpletext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composesimpletext.ui.theme.ComposeSimpleTextTheme
import com.example.composesimpletext.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingText("world")
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
        GreetingText("world")
    }
}

/**
Composable 함수의 첫 글자가 대문자로 시작하는 것은 Composable 함수를
함수로 보는 것이 아닌 위젯 혹은 UI의 구성 요소로 보기 때문이다
(TextView, Button 등의 첫 글자가 대문자인 것처럼)

Composable 함수들 자체도 액티비티에서 분리되어 어디에도 종속되어 있지 않고 아무곳에서나
저장하고 쓸 수 있는데, 이 점이 Jetpack Compose의 장점
 */

// @Composable 어노테이션을 통해 이 함수가 UI의 일부분임을 알려준다
@Composable
fun GreetingText(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier /** Modifier -> 아래서 위로 적용된다!!! */
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