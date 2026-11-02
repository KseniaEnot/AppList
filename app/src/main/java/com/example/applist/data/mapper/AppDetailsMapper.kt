package com.example.applist.data.mapper

import com.example.applist.data.dto.AppDetailsDto
import com.example.applist.domain.model.appDetails.AppDetails

fun AppDetailsDto.toDomain(): AppDetails {
    return AppDetails(
        id = this.id,
        name = this.name,
        developer = this.developer,
        iconUrl = this.iconUrl,
        description = this.description,
        category = this.category.toDomain(),
        ageRating = this.ageRating,
        size = this.size
    )
}