package com.example.applist.domain.usecase

import com.example.applist.domain.model.appDetails.AppDetails
import com.example.applist.domain.repository.AppDetailsRepository


class GetSimilarAppsUseCase(
    private val repository: AppDetailsRepository,
    val appDetails: AppDetails
) {
    suspend operator fun invoke(): List<AppDetails> {
        return repository.getAppsList().filter { it.id != appDetails.id }
            .take(9)
    }
}