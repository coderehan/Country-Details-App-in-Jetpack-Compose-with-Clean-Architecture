package com.example.countrydetailsappinjetpackcompose.domain.model.country_details

data class CountryDetails(
    val currency: Currency,
    val electricity: Electricity,
    val language: List<Language>,
    val names: Names,
    val neighbors: List<Neighbor>,
    val telephone: Telephone,
    val timezone: Timezone,
    val vaccinations: List<Vaccination>,
    val water: Water,
)