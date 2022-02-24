package com.example.mealz.model.api

import com.example.mealz.model.CategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealzApi {
    @GET("/categories.php")
    suspend fun getMealCategories(): Response<CategoriesResponse>

}