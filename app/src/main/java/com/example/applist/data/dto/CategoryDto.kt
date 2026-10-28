package com.example.applist.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CategoryDto {
    @SerialName("Приложения")
    APP,
    @SerialName("Игры")
    GAME,
    @SerialName("Социальные сети")
    SOCIAL,
    @SerialName("Образование")
    EDUCATION,
    @SerialName("Развлечения")
    ENTERTAINMENT,
    @SerialName("Музыка")
    MUSIC,
    @SerialName("Видео")
    VIDEO
}