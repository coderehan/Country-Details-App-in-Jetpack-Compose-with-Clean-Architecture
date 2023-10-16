package com.example.countrydetailsappinjetpackcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.countrydetailsappinjetpackcompose.presentation.country_details.CountryDetailsScreen
import com.example.countrydetailsappinjetpackcompose.presentation.country_list.CountryListScreen

// Here we have used Navigation instead of creating activities

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.CountryListNavigationItem.route       // Our first screen would be country list screen
    ) {
        // Here we have to use inbuilt composable function to place the particular screen
        composable(NavigationItem.CountryListNavigationItem.route) {
            CountryListScreen(navController = navController)
        }

        composable(NavigationItem.CountryDetailsNavigationItem.route) {
            val countryName = it.arguments?.getString("country_name")
            CountryDetailsScreen(countryName = countryName.toString())
        }

    }

}