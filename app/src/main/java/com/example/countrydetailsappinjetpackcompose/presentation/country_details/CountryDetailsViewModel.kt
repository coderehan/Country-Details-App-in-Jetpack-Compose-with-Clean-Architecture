package com.example.countrydetailsappinjetpackcompose.presentation.country_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrydetailsappinjetpackcompose.domain.usecases.GetCountryDetailsUseCase
import com.example.countrydetailsappinjetpackcompose.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

// Our viewmodels will talk with usecase. So we will inject our usecase here.

@HiltViewModel
class CountryDetailsViewModel @Inject constructor(
    private val getCountryDetailsUseCase: GetCountryDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val countryDetailsMutableStateFlow = mutableStateOf(CountryDetailsState())                    // Private MutableStateFlow
    val countryDetailsStateFlow : State<CountryDetailsState> = countryDetailsMutableStateFlow                // Public StateFlow

    init {
        savedStateHandle.getLiveData<String>("country_name").value?.let {
            getCountryDetails(it)
        }
    }

    // This is our view model function
    private fun getCountryDetails(countryName: String){
        // onEach emission, we have to send data from server to our screen state i.e. CountryListState
        getCountryDetailsUseCase(countryName = countryName).onEach {

            when(it){
                is NetworkResult.Loading -> {
                    countryDetailsMutableStateFlow.value = CountryDetailsState(isLoading = true)
                }
                is NetworkResult.Success -> {
                    countryDetailsMutableStateFlow.value = CountryDetailsState(data = it.data)
                }
                is NetworkResult.Error -> {
                    countryDetailsMutableStateFlow.value = CountryDetailsState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)      // We have to tell here on which scope we will launch this viewmodel function
    }

}