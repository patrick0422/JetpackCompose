package com.example.mealz.model


import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("categories")
    val mealCategories: List<MealCategory>
)