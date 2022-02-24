package com.example.mealz.model

import com.example.mealz.NetworkResult
import com.example.mealz.model.api.MealzApi
import retrofit2.Response
import javax.inject.Inject

class MealsRepository @Inject constructor(
    private val mealzApi: MealzApi
) {
    suspend fun getMealCategories(): Response<CategoriesResponse> = mealzApi.getMealCategories()
}