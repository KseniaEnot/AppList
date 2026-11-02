package com.example.applist.data.source

import com.example.applist.data.dto.AppDetailsDto
import com.example.applist.data.dto.CategoryDto

class AppDetailsLocalDataSource {
    private val testApps = listOf(
        AppDetailsDto(
            "1",
            "Name",
            "Dev1",
            "https://img.icons8.ru/color/1200/google-logo.jpg",
            "Description (some text with different information about app)",
            CategoryDto.APP,
            12,
            223.7f
        ),
        AppDetailsDto(
            "2",
            "SecondName",
            "Dev2",
            "https://opis-cdn.tinkoffjournal.ru/mercury/logo-for-business-01.vhhmmr.jpg",
            "321Description (some text with different information about app)",
            CategoryDto.GAME,
            12,
            223.7f),
        AppDetailsDto(
            "3",
            "Last?Name",
            "Dev3",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaGPMHMf6hE5VUbYsUNKyWATbsiGZIEFUVGyEZfnUSCfqiAXHKJvLgX0PP&s=10",
            "555Description (some text with different information about app)",
            CategoryDto.EDUCATION,
            12,
            223.7f),
        AppDetailsDto(
            "4",
            "FirstName",
            "Dev4",
            "https://img.icons8.ru/color/1200/google-logo.jpg",
            "332112Description (some text with different information about app)",
            CategoryDto.ENTERTAINMENT,
            12,
            223.7f),
        AppDetailsDto(
            "5",
            "SecondSecondName",
            "Dev5",
            "https://opis-cdn.tinkoffjournal.ru/mercury/logo-for-business-01.vhhmmr.jpg",
            "bypDescription (some text with different information about app)",
            CategoryDto.GAME,
            12,
            223.7f),
        AppDetailsDto(
            "6",
            "LastNameLast",
            "Dev6",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaGPMHMf6hE5VUbYsUNKyWATbsiGZIEFUVGyEZfnUSCfqiAXHKJvLgX0PP&s=10",
            "??Description (some text with different information about app)",
            CategoryDto.GAME,
            12,
            223.7f),
        AppDetailsDto(
            "7",
            "byptName",
            "Dev7",
            "https://img.icons8.ru/color/1200/google-logo.jpg",
            "(some text with different information about app) Description ",
            CategoryDto.SOCIAL,
            12,
            223.7f),
        AppDetailsDto(
            "8",
            "SecondNameSecond",
            "Dev8",
            "https://opis-cdn.tinkoffjournal.ru/mercury/logo-for-business-01.vhhmmr.jpg",
            "(information about app)",
            CategoryDto.VIDEO,
            12,
            223.7f),
        AppDetailsDto(
            "9",
            "NameLast",
            "Dev9",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaGPMHMf6hE5VUbYsUNKyWATbsiGZIEFUVGyEZfnUSCfqiAXHKJvLgX0PP&s=10",
            "(some text with different information about app)",
            CategoryDto.GAME,
            12,
            223.7f),
    )

    fun getApps(): List<AppDetailsDto> {
        return testApps
    }

}