package com.example.countrydetailsappinjetpackcompose.data.model.country_details


data class CurrencyDTO(
    val code: String?,
    val compare: List<CompareDTO>?,
    val name: String?,
    val rate: String?,
    val symbol: String?
)