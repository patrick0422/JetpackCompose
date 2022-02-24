package com.example.mealz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealz.model.CategoriesResponse
import com.example.mealz.model.MealCategory
import com.example.mealz.model.MealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MealsCategoriesViewModel @Inject constructor(
    private val mealsRepository: MealsRepository
    ): ViewModel() {
    private val _categoriesResponse: MutableLiveData<NetworkResult<CategoriesResponse>> = MutableLiveData()
    val categoriesResponse: LiveData<NetworkResult<CategoriesResponse>> get() = _categoriesResponse

    fun getMealCategories() = viewModelScope.launch {
        val response = mealsRepository.getMealCategories()

        _categoriesResponse.value = try {
            if (response.isSuccessful && response.body() != null) {
                NetworkResult.Success(response.body()!!)
            } else {
                NetworkResult.Error(response.message())
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.stackTraceToString())
        }
    }

}