package com.example.countrydetailsappinjetpackcompose.presentation.country_list

import com.example.countrydetailsappinjetpackcompose.domain.model.country_list.Country

// State is basically a data class which holds data for our views.
// Based on this state data class, we will decide which event we want to show in jetpack compose screens.

data class CountryListState(
    val isLoading: Boolean = false,     // Initially we will keep it false
    val error: String = "",             // Initially we will keep it empty
    val data: List<Country>? = null     // Initially we will keep it null
)
