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
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            runCatching { repository.getAppsList() }
                .onSuccess { apps ->
                    _uiState.value = AppListUiState(
                        isLoading = false,
                        apps = apps
                    )
                }
                .onFailure { e ->
                    _uiState.value = AppListUiState(
                        isLoading = false,
                        error = e.message ?: "Не удалось загрузить каталог"
                    )
                }
        }
    }

    /*init {
        viewModelScope.launch {
            val apps = repository.getAppsList()
            _uiState.value =
                AppListUiState(
                    apps = apps,
                    isLoading = false
                )
        }
    }*/
}

data class AppListUiState(
    val isLoading: Boolean = false,
    val apps: List<AppDetails> = emptyList(),
    val error: String? = null
)