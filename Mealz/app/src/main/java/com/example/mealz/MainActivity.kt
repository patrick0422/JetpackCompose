package com.example.mealz

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealz.ui.theme.MealzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzTheme {
                MealsCategoriesScreen()
            }
        }
    }
}


@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = hiltViewModel()

    viewModel.categoriesResponse.observeAsState {
        Log.d("TAG", "MealsCategoriesScreen: ${viewModel.categoriesResponse.value!!.data!!.mealCategories}")
    }

    viewModel.getMealCategories()

    Text(text = "Hello Compose!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzTheme {
        MealsCategoriesScreen()
    }
}
