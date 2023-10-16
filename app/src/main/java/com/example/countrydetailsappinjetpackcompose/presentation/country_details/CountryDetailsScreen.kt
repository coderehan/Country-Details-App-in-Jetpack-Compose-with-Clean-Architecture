package com.example.countrydetailsappinjetpackcompose.presentation.country_details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.countrydetailsappinjetpackcompose.presentation.country_details.components.CountryHeaderComponent
import com.example.countrydetailsappinjetpackcompose.presentation.country_details.components.CurrencyComponent
import com.example.countrydetailsappinjetpackcompose.presentation.country_details.components.LanguagesComponent
import com.example.countrydetailsappinjetpackcompose.presentation.country_details.components.NeighborComponent
import com.example.countrydetailsappinjetpackcompose.presentation.country_details.components.VaccinationComponent

// Our composable screen will talk with viewmodels and we have to initialize this viewmodel class with hiltViewModel.

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDetailsScreen(
    countryName: String,
    countryDetailsViewModel: CountryDetailsViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = countryName
                    )
                })
        }
    ) {

        val result = countryDetailsViewModel.countryDetails.value

        // Loading case
        if (result.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        // Error case
        if (result.error.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = result.error
                )
            }
        }

        // Success case
        result.data?.let {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())      // Our column will be scrollable.
            ) {
                CountryHeaderComponent(countryDetails = it)
                LanguagesComponent(language = it.language)
                VaccinationComponent(vaccination = it.vaccinations)
                CurrencyComponent(currency = it.currency)
                NeighborComponent(neighbor = it.neighbors)
            }
        }
    }

}