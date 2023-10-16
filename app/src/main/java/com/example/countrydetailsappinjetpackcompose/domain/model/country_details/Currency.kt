package com.example.countrydetailsappinjetpackcompose.domain.model.country_details

data class Currency(
    val code: String,
    val compare: List<Compare>,
    val name: String,
    val rate: String,
    val symbol: Any
)