package com.example.applist.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.applist.model.appDetails.AppDetails
import com.example.applist.model.appDetails.AppDetailsRep
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppListViewModel(
    private val repository: AppDetailsRep
) : ViewModel() {

    private val _uiState = MutableStateFlow(AppListUiState(isLoading = true))
    private val _snackbarEvents = MutableSharedFlow<String>()
    val uiState: StateFlow<AppListUiState> = _uiState.asStateFlow()
    val snackbarEvents: SharedFlow<String> = _snackbarEvents.asSharedFlow()


    init {
        viewModelScope.launch {
            val apps = repository.getTestAppsList()
            _uiState.value = AppListUiState(apps = apps, isLoading = false)
        }
    }

    companion object {
        fun factory(repository: AppDetailsRep) = viewModelFactory {
            initializer { AppListViewModel(repository) }
        }
    }
}

data class AppListUiState(
    val isLoading: Boolean = false,
    val apps: List<AppDetails> = emptyList()
)