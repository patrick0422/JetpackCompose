package com.example.mealz.model


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val categoryId: String,
    @SerializedName("strCategory")
    val CategoryName: String,
    @SerializedName("strCategoryThumb")
    val CategoryThumb: String,
    @SerializedName("strCategoryDescription")
    val CategoryDescription: String
)