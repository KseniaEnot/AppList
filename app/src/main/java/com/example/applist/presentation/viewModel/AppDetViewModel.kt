package com.example.applist.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.applist.domain.model.appDetails.AppDetails
import com.example.applist.domain.repository.AppDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: AppDetailsRepository
) : ViewModel() {

    private val appId: String = checkNotNull(savedStateHandle["appId"])

    private val _uiState = MutableStateFlow(
        AppDetailsUiState(
            isLoading = true
        )
    )
    val uiState: StateFlow<AppDetailsUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val all = repository.getAppsList()
            val app = all.firstOrNull { it.id == appId }
            if (app != null) {
                _uiState.value =
                    AppDetailsUiState(
                        app = app,
                        similarApps = repository.getSimAppsList(app),
                        isLoading = false
                    )
            }
        }
    }

    companion object {
        fun factory(repository: AppDetailsRepository) = viewModelFactory {
            initializer {
                AppDetViewModel(
                    savedStateHandle = createSavedStateHandle(),
                    repository = repository
                )
            }
        }
    }
}

data class AppDetailsUiState(
    val isLoading: Boolean = false,
    val app: AppDetails? = null,
    val similarApps: List<AppDetails> = emptyList()
)