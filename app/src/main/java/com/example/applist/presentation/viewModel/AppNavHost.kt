package com.example.applist.presentation.viewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applist.domain.model.navigation.AppDetailsRoute
import com.example.applist.domain.model.navigation.AppListRoute
import com.example.applist.presentation.view.appDetails.AppDetailsScreen
import com.example.applist.presentation.view.appList.AppListScreen
import com.example.applist.presentation.view.stateScreens.ErrorScreen
import com.example.applist.presentation.view.stateScreens.LoadingScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppListRoute
    ) {
        composable<AppListRoute> {
            val vm: AppListViewModel = hiltViewModel()
            val state by vm.uiState.collectAsState()

            AppListScreen(
                appDetailList = state.apps,
                onAppClick = { app ->
                    navController.navigate(AppDetailsRoute(app.id))
                },
                onBack = { navController.popBackStack() },
                onSearch = {},
            )
        }

        composable<AppDetailsRoute> {
            val vm: AppDetViewModel = hiltViewModel()
            val state by vm.uiState.collectAsState()
            val app = state.app

            when {
                state.isLoading -> LoadingScreen()
                app != null -> AppDetailsScreen(
                    appDetails = app, //state.app,
                    similarApps = state.similarApps,
                    onBack = { navController.popBackStack() },
                    onOpenAppDetails = { navController.navigate(AppDetailsRoute(it.id)) },
                    onSimilarAppDownloadClick = {},
                    onReadMoreClick = {}
                )
                else -> ErrorScreen(
                    message = state.error ?: "Приложение не найдено",
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}