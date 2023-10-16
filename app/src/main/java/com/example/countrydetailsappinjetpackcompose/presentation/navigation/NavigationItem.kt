package com.example.countrydetailsappinjetpackcompose.presentation.navigation

// We have 2 navigation items i.e. (1) CountryListScreen (2) CountryDetailsScreen
sealed class NavigationItem(val route: String) {
    object CountryListNavigationItem : NavigationItem(route = "country_list")
    object CountryDetailsNavigationItem : NavigationItem(route = "country_details/{country_name}")  // Here we have to pass argument {country_name} because based on this only we will show country details.
}
