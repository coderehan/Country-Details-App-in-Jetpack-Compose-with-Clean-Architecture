package com.example.countrydetailsappinjetpackcompose.presentation.country_details.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.Compare
import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.CountryDetails
import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.Currency
import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.Language
import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.Neighbor
import com.example.countrydetailsappinjetpackcompose.domain.model.country_details.Vaccination

// This component class is created to place all the breakable components of the screen.
@Composable
fun CountryHeaderComponent(countryDetails: CountryDetails) {

    Text(
        text = countryDetails.names.full,
        style = TextStyle(
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = Modifier
            .padding(12.dp)
    )

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {     // Row open

        Text(
            text = "Continent : ${countryDetails.names.continent}",
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(8.dp)
        )

        Text(
            text = "TimeZone : ${countryDetails.timezone.name}",
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(8.dp)
        )
    }       // Row closed

    Text(
        text = "Telephone",
        style = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = Modifier
            .padding(12.dp)
    )

    Text(
        text = "Ambulance : ${countryDetails.telephone.ambulance}",
        style = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        modifier = Modifier
            .padding(horizontal = 12.dp)
    )

    Text(
        text = "Calling Code : ${countryDetails.telephone.calling_code}",
        style = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        modifier = Modifier
            .padding(horizontal = 12.dp)
    )

    Text(
        text = "Police : ${countryDetails.telephone.police}",
        style = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        modifier = Modifier
            .padding(horizontal = 12.dp)
    )

    Text(
        text = "fire : ${countryDetails.telephone.fire}",
        style = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        modifier = Modifier
            .padding(horizontal = 12.dp)
    )

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LanguagesComponent(language: List<Language>) {
    Text(
        text = "Languages",
        style = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = Modifier
            .padding(12.dp)
    )

    FlowRow {
        language.forEach {
            // We will place child list items inside this
            LanguageItems(language = it)
        }
    }
}

@Composable
fun LanguageItems(language: Language) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .wrapContentSize(),
        border = BorderStroke(1.dp, color = Color.Black),
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            text = language.language,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

@Composable
fun VaccinationComponent(vaccination: List<Vaccination>) {
    Text(
        text = "Vaccinations",
        style = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = Modifier
            .padding(12.dp)
    )

    LazyRow {
        items(vaccination) {
            // We will place child list items inside this
            VaccinationItems(vaccination = it)
        }
    }
}

@Composable
fun VaccinationItems(vaccination: Vaccination) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .wrapContentSize(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(
                text = vaccination.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .padding(8.dp),
                textDecoration = TextDecoration.Underline
            )

            Text(
                text = vaccination.message,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .width(150.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis        // This means after 3 line it will show dot dot dot
            )
        }
    }
}

@Composable
fun CurrencyComponent(currency: Currency) {
    Text(
        text = "Currency",
        style = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = Modifier
            .padding(12.dp)
    )

    LazyRow {
        items(currency.compare) {
            // We will place child list items inside this
            CurrencyItems(currency = currency, compare = it)
        }
    }
}

@Composable
fun CurrencyItems(currency: Currency, compare: Compare) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .wrapContentSize(),
        shape = RoundedCornerShape(8.dp),
        colors = if (currency.rate.toDouble() >= compare.rate.toDouble()) CardDefaults.cardColors(
            Color.Green
        ) else CardDefaults.cardColors(Color.Red)
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = compare.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                ),
                modifier = Modifier
                    .padding(4.dp)
            )

            Text(
                text = "1$ = ${compare.rate}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                ),
                modifier = Modifier
                    .padding(4.dp)
            )

            Text(
                text = if (currency.rate.toDouble() >= compare.rate.toDouble()) "Low" else "High",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                ),
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun NeighborComponent(neighbor: List<Neighbor>) {
    Text(
        text = "Neighbor",
        style = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = Modifier
            .padding(12.dp)
    )

    LazyRow {
        items(neighbor) {
            // We will place child list items inside this
            NeighborItems(neighbor = it)
        }
    }
}

@Composable
fun NeighborItems(neighbor: Neighbor) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize()
    ) {
        Text(
            text = neighbor.name,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .padding(4.dp)
        )
    }
}