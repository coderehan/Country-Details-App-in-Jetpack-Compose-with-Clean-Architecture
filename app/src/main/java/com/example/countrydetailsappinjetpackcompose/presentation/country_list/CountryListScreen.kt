package com.example.countrydetailsappinjetpackcompose.presentation.country_list

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.countrydetailsappinjetpackcompose.domain.model.country_list.Country

// Our composable screen will talk with viewmodels and we have to initialize this viewmodel class with hiltViewModel.
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("StateFlowValueCalledInComposition", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CountryListScreen(
    navController: NavController,
    countryListViewModel: CountryListViewModel = hiltViewModel()
) {

    val result = countryListViewModel.countryListStateFlow.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Country List"
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Transparent)
            )
        }
    ) {     // Scaffold open

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
        if (result.error.isNotBlank()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = result.error.toString()
                )
            }
        }

        // Success case
        result.data?.let {
            // Here we will show list of data
            LazyColumn {
                items(it) {
                    // Here we have to place our child view items
                    CountryListItems(country = it) {
                        navController.navigate("country_details/${it}")
                    }
                }
            }
        }
    }           // Scaffold closed


}

@Composable
fun CountryListItems(
    country: Country,
    onClick: (String) -> Unit       // The reason why we mark it string data type is we have to pass country name from list screen to details screen.
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {                    // On clicking of this card, we have to navigate to next page
                onClick(country.name)       // Passing country name here
            },
    ) {
        Text(
            text = country.name,
            modifier = Modifier
                .padding(8.dp),
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.W600,
                fontSize = 18.sp
            )
        )
    }
}