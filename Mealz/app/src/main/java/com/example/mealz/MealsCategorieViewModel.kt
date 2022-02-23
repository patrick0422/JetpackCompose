package com.example.mealz

import androidx.lifecycle.ViewModel
import com.example.mealz.model.MealCategory
import com.example.mealz.model.MealsRepository

class MealsCategoriesViewModel(private val mealsRepository: MealsRepository): ViewModel() {
    fun getMealCategories(): List<MealCategory> = mealsRepository.getMealCategories().mealCategories
}