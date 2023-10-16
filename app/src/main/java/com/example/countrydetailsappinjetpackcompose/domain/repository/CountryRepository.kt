package com.example.countrydetailsappinjetpackcompose.domain.repository

import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.CountryDetails
import com.example.countrydetailsappinjetpackcompose.domain.model.country_list.Country


// We will be implementing this interface repository in data layer repository.

interface CountryRepository {

    suspend fun getCountryList(): List<Country>

    suspend fun getCountryDetails(countryName: String): CountryDetails

}