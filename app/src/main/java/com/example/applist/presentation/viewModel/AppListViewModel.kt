package com.example.applist.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applist.domain.model.appDetails.AppDetails
import com.example.applist.domain.repository.AppDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val repository: AppDetailsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        AppListUiState(
            isLoading = true
        )
    )
    val uiState: StateFlow<AppListUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            val apps = repository.getAppsList()
            _uiState.value =
                AppListUiState(
                    apps = apps,
                    isLoading = false
                )
        }
    }
}

data class AppListUiState(
    val isLoading: Boolean = false,
    val apps: List<AppDetails> = emptyList()
)