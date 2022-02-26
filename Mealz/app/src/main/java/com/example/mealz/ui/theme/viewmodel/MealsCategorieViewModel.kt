package com.example.mealz.ui.theme.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealz.model.CategoriesResponse
import com.example.mealz.model.MealsRepository
import com.example.mealz.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MealsCategoriesViewModel @Inject constructor(
    private val mealsRepository: MealsRepository
    ): ViewModel() {

    /** 기존 LiveData 방식 */
//    private val _categoriesResponse: MutableLiveData<NetworkResult<CategoriesResponse>> = MutableLiveData()
//    val categoriesResponse: LiveData<NetworkResult<CategoriesResponse>> get() = _categoriesResponse
//
//    fun getMealCategories() = viewModelScope.launch {
//        val response = mealsRepository.getMealCategories()
//
//        _categoriesResponse.value = try {
//            if (response.isSuccessful && response.body() != null) {
//                NetworkResult.Success(response.body()!!)
//            } else {
//                NetworkResult.Error(response.message())
//            }
//        } catch (e: Exception) {
//            NetworkResult.Error(e.stackTraceToString())
//        }
//    }

    init {
        getCategoriesState()
    }

    /** State 이용하는 방식 */
    private val _categoriesState: MutableState<NetworkResult<CategoriesResponse>> = mutableStateOf(
        NetworkResult.Loading())
    val categoriesState: State<NetworkResult<CategoriesResponse>> get() = _categoriesState

    private fun getCategoriesState() = viewModelScope.launch {
        val response = mealsRepository.getMealCategories()

        _categoriesState.value = try {
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