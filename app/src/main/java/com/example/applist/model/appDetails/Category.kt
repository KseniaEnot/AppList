package com.example.applist.model.appDetails

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Category {
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