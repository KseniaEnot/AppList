package com.example.applist.data.repository

import com.example.applist.data.mapper.toDomain
import com.example.applist.data.source.AppDetailsLocalDataSource
import com.example.applist.domain.model.appDetails.AppDetails
import com.example.applist.domain.repository.AppDetailsRepository

class AppDetailsRepositoryImpl(
    private val localDataSource: AppDetailsLocalDataSource
) : AppDetailsRepository {
    override suspend fun getAppsList(): List<AppDetails> {
        val appDetailsDtos = localDataSource.getApps()
        return appDetailsDtos.map {it.toDomain()}
    }

    override suspend fun getSimAppsList(app: AppDetails): List<AppDetails> {
        val appDetailsDtos = localDataSource.getApps()
        return appDetailsDtos.filter { it.id != app.id }
            .take(9)
            .map {it.toDomain()}
    }

    override suspend fun getAppsById(id: String): AppDetails? {
        return localDataSource.getApps()
            .find { it.id == id }
            ?.toDomain()
    }
}