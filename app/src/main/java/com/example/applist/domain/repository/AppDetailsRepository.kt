package com.example.applist.domain.repository

import com.example.applist.domain.model.appDetails.AppDetails

interface  AppDetailsRepository {
    suspend fun getAppsList(): List<AppDetails>

    suspend fun getSimAppsList(app: AppDetails): List<AppDetails>

    suspend fun getAppsById(id: String): AppDetails?
}