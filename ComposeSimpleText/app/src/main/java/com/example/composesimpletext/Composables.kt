package com.example.composesimpletext

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

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
    Text(text = "Hello $name!")
}

@Composable
fun GreetingButton() {
    Button(onClick = {  }) {
        GreetingText("Button")
    }
}