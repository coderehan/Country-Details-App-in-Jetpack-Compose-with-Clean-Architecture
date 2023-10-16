package com.example.countrydetailsappinjetpackcompose.data.network

import com.example.countrydetailsappinjetpackcompose.data.model.country_details.CountryDetailsDTO
import com.example.countrydetailsappinjetpackcompose.data.model.country_list.CountryDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("countries.json")
    suspend fun getCountryList(): List<CountryDTO>

    @GET("{country_name}")                              // "{}" denotes dynamic which means user can select any country from the list and for this we have to use @Path annotation
    suspend fun getCountryDetails(                      // The end point looks like this https://travelbriefing.org/India?format.json where India is the country name & format is the query name
        @Path("country_name") countryName: String,
        @Query("format") format: String = "json"        // "format" is the actual query in endpoint and for this we will use @Query annotation. In end point, if we look at carefully format is actually in json type. So we have to initialize it in json also
    ): CountryDetailsDTO

}