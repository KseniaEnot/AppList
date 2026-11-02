package com.example.applist.data.dto

data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val iconUrl: String,
    val description: String,
    val category: CategoryDto,
    val ageRating: Int,
    val size: Float,
)