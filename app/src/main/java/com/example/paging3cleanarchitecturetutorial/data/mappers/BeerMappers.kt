package com.example.paging3cleanarchitecturetutorial.data.mappers

import com.example.paging3cleanarchitecturetutorial.data.local.BeerEntity
import com.example.paging3cleanarchitecturetutorial.data.remote.BeerDto
import com.example.paging3cleanarchitecturetutorial.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity = BeerEntity(
    id = id,
    name = name,
    tagline = tagline,
    description = description,
    firstBrewed = first_brewed,
    imageUrl = image_url
)

fun BeerEntity.toBeer(): Beer  = Beer(
    id = id,
    name = name,
    tagline = tagline,
    description = description,
    firstBrewed = firstBrewed,
    imageUrl = imageUrl
)