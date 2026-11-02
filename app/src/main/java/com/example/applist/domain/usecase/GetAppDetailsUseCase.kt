package com.example.applist.domain.usecase

import com.example.applist.domain.model.appDetails.AppDetails
import com.example.applist.domain.repository.AppDetailsRepository

class GetSortedAppDetailsUseCase(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke(): List<AppDetails> {
        return repository.getAppsList().sortedBy { it.category }
    }
}