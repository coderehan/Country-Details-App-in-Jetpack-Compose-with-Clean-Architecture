package com.example.countrydetailsappinjetpackcompose.domain.usecases

import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.CountryDetails
import com.example.countrydetailsappinjetpackcompose.domain.repository.CountryRepository
import com.example.countrydetailsappinjetpackcompose.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

// Our usecase will talk with repository and in this usecase we will be storing our api response.
// Usecase is basically feature. So in that feature only we have to store our api response.
// With the help of this usecase, we get our CountryDetails data.

class GetCountryDetailsUseCase(private val countryRepository: CountryRepository) {

    // Here we will be showing CountryDetails data.
    // We will use operator function and whenever we use operator, we have to use invoke keyword only. We cannot use other names.
    // We will use flow builder to emit data.

    // Here we need country name. So we have to pass countryName parameter in invoke function.
    operator fun invoke(countryName: String): Flow<NetworkResult<CountryDetails>> = flow {
        // First we will show loading until we get desired data from server
        emit(NetworkResult.Loading())

        try {
            // Here we will store our api response data in success case
            emit(NetworkResult.Success(data = countryRepository.getCountryDetails(countryName = countryName)))
        } catch (e: Exception) {
            // Here we will catch any exception that comes in failure case
            emit(NetworkResult.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)        // We have to execute this flow in IO background thread
}