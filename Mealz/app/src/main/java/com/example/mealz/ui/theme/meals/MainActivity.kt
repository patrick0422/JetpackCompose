package com.example.mealz.ui.theme.meals

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mealz.ui.theme.viewmodel.MealsCategoriesViewModel
import com.example.mealz.util.NetworkResult
import com.example.mealz.ui.theme.MealzTheme
import com.example.mealz.util.Constants.Companion.TAG
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

    when(val categories = viewModel.categoriesState.value) {
        is NetworkResult.Success -> {
            LazyColumn {
                items(categories.data!!.mealCategories) { category ->
                    Text(text = category.CategoryName)
                }
            }
        }
        is NetworkResult.Error -> {
            Log.d(TAG, "MealsCategoriesScreen: ${categories.message}")
            Text(text = "ERROR!! Message: ${categories.message}")
        }
        is NetworkResult.Loading -> {
            Text(text = "Loading...")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzTheme {
        MealsCategoriesScreen()
    }
}
