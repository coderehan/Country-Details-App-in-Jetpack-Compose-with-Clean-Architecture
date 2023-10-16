package com.example.countrydetailsappinjetpackcompose.data.di

import com.example.countrydetailsappinjetpackcompose.data.network.ApiService
import com.example.countrydetailsappinjetpackcompose.data.repository.CountryRepositoryImpl
import com.example.countrydetailsappinjetpackcompose.domain.repository.CountryRepository
import com.example.countrydetailsappinjetpackcompose.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Mention all the API interfaces of data layer and repositories of domain layer here in Hilt that we are going to use in this app.

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providesCountryRepository(apiService: ApiService): CountryRepository {       // CountryRepository is an interface. Interface has always impl to return. So we will return CountryRepositoryImpl.
        return CountryRepositoryImpl(apiService)
    }
}