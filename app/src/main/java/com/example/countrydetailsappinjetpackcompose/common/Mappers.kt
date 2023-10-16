package com.example.countrydetailsappinjetpackcompose.common

import com.example.countrydetailsappinjetpackcompose.data.model.country_details.*
import com.example.countrydetailsappinjetpackcompose.data.model.country_list.*
import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.*
import com.example.countrydetailsappinjetpackcompose.domain.model.country_list.*


// We have created this mappers class separate inorder to transfer data from data layer model class variables to domain layer model class variables
// Here we will be using extension function i.e. ClassName.FunctionName
// Eg: CountryDetailsDTO is the ClassName & toDomain() is the FunctionName

fun CountryDetailsDTO.toDomain(): CountryDetails {
    return CountryDetails(
        // Make sure to pass empty string as "" & empty list inorder to avoid app crashing if api send null value from server database
        currency = currency?.toDomain() ?: Currency("", emptyList(), "", "", ""),
        electricity = electricity?.toDomain() ?: Electricity("", ""),
        language = language?.map { it.toDomain() } ?: emptyList(),
        names = names?.toDomain() ?: Names("", "", "", "", ""),
        neighbors = neighbors?.map { it.toDomain() } ?: emptyList(),
        telephone = telephone?.toDomain() ?: Telephone("", "", "", ""),
        timezone = timezone?.toDomain() ?: Timezone(""),
        vaccinations = vaccinations?.map { it.toDomain() } ?: emptyList(),
        water = water?.toDomain() ?: Water("", ""),
    )
}


fun CountryDTO.toDomain(): Country {
    return Country(
        // Make sure to pass empty string as "" inorder to avoid app crashing if api send null value from server database
        name = name ?: "",       // name is the domain layer variable on the left side. So in this variable, we will map data layer variable. Thus we are mapping data from data layer to domain layer.
        url = url ?: ""
    )
}


fun CurrencyDTO.toDomain(): Currency {
    return Currency(
        code = code ?: "",
        compare = compare?.map {     // For list, we will be using map keyword to map from data layer to domain layer
            it.toDomain()
        }
            ?: emptyList(),                     // Make sure to pass empty list inorder to avoid app crashing if api send null value from server database
        name = name ?: "",
        rate = rate ?: "",
        symbol = symbol ?: ""
    )
}

fun CompareDTO.toDomain(): Compare {
    return Compare(
        name = name ?: "",
        rate = rate ?: ""
    )
}

fun ElectricityDTO.toDomain(): Electricity {
    return Electricity(
        frequency = frequency ?: "",
        voltage = voltage ?: ""
    )
}

fun LanguageDTO.toDomain(): Language {
    return Language(
        language = language ?: "",
        official = official ?: ""
    )
}

fun NamesDTO.toDomain(): Names {
    return Names(
        continent = continent ?: "",
        full = full ?: "",
        iso2 = iso2 ?: "",
        iso3 = iso3 ?: "",
        name = name ?: ""
    )
}

fun NeighborDTO.toDomain(): Neighbor {
    return Neighbor(
        id = id ?: "",
        name = name ?: ""
    )
}

fun TelephoneDTO.toDomain(): Telephone {
    return Telephone(
        ambulance = ambulance ?: "",
        calling_code = calling_code ?: "",
        fire = fire ?: "",
        police = police ?: ""
    )
}

fun TimezoneDTO.toDomain(): Timezone {
    return Timezone(
        name = name ?: ""
    )
}

fun VaccinationDTO.toDomain(): Vaccination {
    return Vaccination(
        message = message ?: "",
        name = name ?: "",
    )
}

fun WaterDTO.toDomain(): Water {
    return Water(
        full = full ?: "",
        short = short ?: ""
    )
}