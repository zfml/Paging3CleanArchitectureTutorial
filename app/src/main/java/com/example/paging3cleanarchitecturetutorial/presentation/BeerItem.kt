package com.example.paging3cleanarchitecturetutorial.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.paging3cleanarchitecturetutorial.domain.Beer

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RectangleShape
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
             AsyncImage(
                 model = beer.imageUrl,
                 contentDescription = beer.name,
                 modifier = Modifier
                     .weight(1f)
                     .height(150.dp)
             )
             Spacer(modifier = Modifier.width(16.dp))

            Column (
               modifier = Modifier
                   .weight(3f),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = beer.name,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.tagline,
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray,
                   modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "First Brewed in ${beer.firstBrewed}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 8.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

            }

        }
    }
}


@Preview
@Composable
fun BeerItemPreview() {

    BeerItem(
        beer = Beer(
            id = 0,
            name = "Beer",
            tagline = "Beer Tag Line",
            firstBrewed = "2023",
            description = "Beer is good for most of the people",
            imageUrl = null
        ),
        modifier = Modifier.fillMaxWidth()
    )
}