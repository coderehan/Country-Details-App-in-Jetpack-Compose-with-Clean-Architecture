package com.example.countrydetailsappinjetpackcompose.data.repository

import com.example.countrydetailsappinjetpackcompose.common.toDomain
import com.example.countrydetailsappinjetpackcompose.data.network.ApiService
import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.CountryDetails
import com.example.countrydetailsappinjetpackcompose.domain.model.country_list.Country
import com.example.countrydetailsappinjetpackcompose.domain.repository.CountryRepository

// Here in this repository, we will be implementing domain layer repository interface
// This repository will talk with api interface

class CountryRepositoryImpl(private val apiService: ApiService) : CountryRepository {

    override suspend fun getCountryList(): List<Country> {
        return apiService.getCountryList().map {                        // For list only, we use map keyword and then we will convert it to our domain layer
            it.toDomain()
        }
    }

    override suspend fun getCountryDetails(countryName: String): CountryDetails {
        return apiService.getCountryDetails(countryName = countryName).toDomain()   // Here we don't need to use map keyword because we are not showing this in list. We can directly convert it to our domain layer
    }
}