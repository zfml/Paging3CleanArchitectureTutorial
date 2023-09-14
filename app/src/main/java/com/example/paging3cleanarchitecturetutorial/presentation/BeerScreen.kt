package com.example.paging3cleanarchitecturetutorial.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey

import com.example.paging3cleanarchitecturetutorial.domain.Beer
import java.lang.Error

@Composable
fun BeerScreen(
    beers: LazyPagingItems<Beer>
) {

    val context = LocalContext.current


    LaunchedEffect(key1 = beers.loadState) {

        if(beers.loadState.refresh is LoadState.Error) {

            Toast.makeText(
                context,
                "Error: " + (beers.loadState.refresh as LoadState.Error).error,
                Toast.LENGTH_LONG
            ).show()

        }

    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if(beers.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center )
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
               items(
                   count = beers.itemCount,
                   key = beers.itemKey { it -> it.id}
               ) { index ->
                   val beer = beers[index]
                   if (beer != null) {
                       BeerItem(beer = beer)
                   }
               }

               item {
                   if(beers.loadState.append is LoadState.Loading) {
                       CircularProgressIndicator()
                   }
               }
            }
        }
    }


}