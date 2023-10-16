package com.example.countrydetailsappinjetpackcompose.domain.usecases

import android.util.Log
import com.example.countrydetailsappinjetpackcompose.domain.model.country_list.Country
import com.example.countrydetailsappinjetpackcompose.domain.repository.CountryRepository
import com.example.countrydetailsappinjetpackcompose.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

// Our usecase will talk with repository and in this usecase we will be storing our api response.
// Usecase is basically feature. So in that feature only we have to store our api response.
// With the help of this usecase, we get our list of CountryList data.

class GetCountryListUseCase(private val countryRepository: CountryRepository) {

    // Here we will be showing list of data for CountryList.
    // We will use operator function and whenever we use operator, we have to use invoke keyword only. We cannot use other names.
    // We will use flow builder to emit data.

    operator fun invoke(): Flow<NetworkResult<List<Country>>> = flow {
        // First we will show loading until we get desired data from server
        emit(NetworkResult.Loading())

        try {
            // Here we will store our api response data in success case
            emit(NetworkResult.Success(data = countryRepository.getCountryList()))
        } catch (e: Exception) {
            // Here we will catch any exception that comes in failure case
            emit(NetworkResult.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)        // We have to execute this flow in IO background thread
}