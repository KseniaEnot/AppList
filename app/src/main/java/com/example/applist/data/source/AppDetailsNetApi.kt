package com.example.applist.data.source

import com.example.applist.data.dto.AppDetNetDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppDetailsNetApi {

    @GET("catalog")
    suspend fun getApps(): List<AppDetNetDto>

    @GET("{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetNetDto
}