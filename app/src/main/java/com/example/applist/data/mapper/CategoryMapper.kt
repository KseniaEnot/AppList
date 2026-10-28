package com.example.applist.data.mapper

import com.example.applist.data.dto.CategoryDto
import com.example.applist.domain.model.appDetails.Category

fun CategoryDto.toDomain(): Category = when (this)  {
    CategoryDto.APP -> Category.APP
    CategoryDto.GAME -> Category.GAME
    CategoryDto.SOCIAL -> Category.SOCIAL
    CategoryDto.EDUCATION -> Category.EDUCATION
    CategoryDto.ENTERTAINMENT -> Category.ENTERTAINMENT
    CategoryDto.MUSIC -> Category.MUSIC
    CategoryDto.VIDEO -> Category.VIDEO
}