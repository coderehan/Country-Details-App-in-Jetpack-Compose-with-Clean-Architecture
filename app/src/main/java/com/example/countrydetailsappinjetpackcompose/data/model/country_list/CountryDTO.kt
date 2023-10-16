package com.example.countrydetailsappinjetpackcompose.data.model.country_list

// The reason why we add ? in all String is sometimes api may send null value and if null value comes, our app will crash.
// So for null safety we use ? to avoid crashing app

data class CountryDTO(
    val name: String? = null,
    val url: String? = null
)