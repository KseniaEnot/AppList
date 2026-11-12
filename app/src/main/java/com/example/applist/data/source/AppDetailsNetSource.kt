package com.example.applist.data.source

import com.example.applist.data.dto.AppDetNetDto
import javax.inject.Inject

class AppDetailsNetSource @Inject constructor(
    private val api: AppDetailsNetApi
)  {
    suspend fun getCatalog(): List<AppDetNetDto> {
        return api.getApps()
    }

    suspend fun getAppDetails(id: String): AppDetNetDto {
        return api.getAppDetails(id)
    }

}