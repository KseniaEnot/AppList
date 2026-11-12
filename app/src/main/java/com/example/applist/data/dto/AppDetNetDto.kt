package com.example.applist.data.dto

data class AppDetNetDto(
    val id: String,
    val name: String,
    val iconUrl: String,
    val description: String,
    val category: String // TODO: получить полный список категорий и привести их к enum
)
