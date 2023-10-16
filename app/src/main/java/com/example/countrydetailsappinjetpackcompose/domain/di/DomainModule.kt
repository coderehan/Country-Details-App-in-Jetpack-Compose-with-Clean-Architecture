package com.example.countrydetailsappinjetpackcompose.domain.di

import com.example.countrydetailsappinjetpackcompose.domain.repository.CountryRepository
import com.example.countrydetailsappinjetpackcompose.domain.usecases.GetCountryDetailsUseCase
import com.example.countrydetailsappinjetpackcompose.domain.usecases.GetCountryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    // Mention all the usecases of domain layer here in Hilt that we are going to use in this app.

    @Provides
    fun providesGetCountryListUseCase(countryRepository: CountryRepository): GetCountryListUseCase{
        return GetCountryListUseCase(countryRepository = countryRepository)
    }

    @Provides
    fun providesGetCountryDetailsUseCase(countryRepository: CountryRepository): GetCountryDetailsUseCase{
        return GetCountryDetailsUseCase(countryRepository = countryRepository)
    }

}