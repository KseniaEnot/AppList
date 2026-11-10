package com.example.applist.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
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
class AppDetViewModel @Inject constructor(
    private val repository: AppDetailsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val appId: String = checkNotNull(savedStateHandle["appId"])

    private val _uiState = MutableStateFlow(
        AppDetailsUiState(
            isLoading = true
        )
    )
    val uiState: StateFlow<AppDetailsUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            runCatching {
                val all = repository.getAppsList()
                val app = all.firstOrNull { it.id == appId }
                    ?: error("Приложение не найдено")
                app to repository.getSimAppsList(app)
            }.onSuccess { (app, similar) ->
                _uiState.value = AppDetailsUiState(
                    isLoading = false,
                    app = app,
                    similarApps = similar
                )
            }.onFailure { e ->
                _uiState.value = AppDetailsUiState(
                    isLoading = false,
                    error = e.message ?: "Не удалось загрузить приложение"
                )
            }
        }
    }
}

data class AppDetailsUiState(
    val isLoading: Boolean = false,
    val app: AppDetails? = null,
    val similarApps: List<AppDetails> = emptyList(),
    val error: String? = null
)