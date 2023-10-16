package com.example.countrydetailsappinjetpackcompose.presentation.country_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrydetailsappinjetpackcompose.domain.usecases.GetCountryListUseCase
import com.example.countrydetailsappinjetpackcompose.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

// Our viewmodels will talk with usecase. So we will inject our usecase here.

@HiltViewModel
class CountryListViewModel @Inject constructor(private val getCountryListUseCase: GetCountryListUseCase): ViewModel() {

    init {
        getCountryList()
    }

    private val countryListMutableStateFlow = mutableStateOf(CountryListState())                     // Private MutableStateFlow
    val countryListStateFlow : State<CountryListState> = countryListMutableStateFlow                // Public StateFlow

    // This is our view model function
    private fun getCountryList(){
        // onEach emission, we have to send data from server to our screen state i.e. CountryListState
        getCountryListUseCase().onEach {

            when(it){
                is NetworkResult.Loading -> {
                    countryListMutableStateFlow.value = CountryListState(isLoading = true)
                }
                is NetworkResult.Success -> {
                    countryListMutableStateFlow.value = CountryListState(data = it.data)
                }
                is NetworkResult.Error -> {
                    countryListMutableStateFlow.value = CountryListState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)      // We have to tell here on which scope we will launch this viewmodel function
    }
}