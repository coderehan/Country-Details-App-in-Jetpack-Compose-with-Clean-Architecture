package com.example.countrydetailsappinjetpackcompose.data.model.country_details

// The reason why we add ? in all String is sometimes api may send null value and if null value comes, our app will crash.
// So for null safety we use ? to avoid crashing app

data class CountryDetailsDTO(
    val currency: CurrencyDTO?,
    val electricity: ElectricityDTO?,
    val language: List<LanguageDTO>?,
    val names: NamesDTO?,
    val neighbors: List<NeighborDTO>?,
    val telephone: TelephoneDTO?,
    val timezone: TimezoneDTO?,
    val vaccinations: List<VaccinationDTO>?,
    val water: WaterDTO?
)