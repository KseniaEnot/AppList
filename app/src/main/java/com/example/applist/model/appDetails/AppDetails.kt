package com.example.applist.model.appDetails

data class AppDetails(
    val id: String,
    val name: String,
    val iconUrl: String,
    val description: String,
    val category: Category
)
