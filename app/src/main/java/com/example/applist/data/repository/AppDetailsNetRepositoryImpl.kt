package com.example.applist.data.repository

import com.example.applist.data.mapper.toDomain
import com.example.applist.data.source.AppDetailsNetSource
import com.example.applist.domain.model.appDetails.AppDetails
import com.example.applist.domain.repository.AppDetailsRepository
import javax.inject.Inject

class AppDetailsNetRepositoryImpl @Inject constructor(
    private val remoteDataSource: AppDetailsNetSource
) : AppDetailsRepository {
    override suspend fun getAppsList(): List<AppDetails> {
        val dtos = remoteDataSource.getCatalog()
        return dtos.map { it.toDomain() }
    }

    override suspend fun getSimAppsList(app: AppDetails): List<AppDetails> {
        val dtos = remoteDataSource.getCatalog()
        return dtos.filter { it.id != app.id }
            .take(9)
            .map {it.toDomain()}
        //return emptyList()
    }

    override suspend fun getAppsById(id: String): AppDetails? {
        val dtos = remoteDataSource.getAppDetails(id)
        return dtos.toDomain()
    }
}