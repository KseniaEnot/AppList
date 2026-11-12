package com.example.applist.data.mapper

import com.example.applist.data.dto.AppDetNetDto
import com.example.applist.domain.model.appDetails.AppDetails
import com.example.applist.domain.model.appDetails.Category

fun AppDetNetDto.toDomain(): AppDetails {
    return AppDetails(
        id = this.id,
        name = this.name,
        developer = "",
        iconUrl = this.iconUrl,
        description = "",
        category = Category.APP, // TODO: тянуть enum
        ageRating = 0,
        size = 0f
    )
}