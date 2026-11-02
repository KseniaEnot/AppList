package com.example.applist.presentation.viewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applist.data.repository.AppDetailsRepositoryImpl
import com.example.applist.data.source.AppDetailsLocalDataSource
import com.example.applist.domain.model.navigation.AppDetailsRoute
import com.example.applist.domain.model.navigation.AppListRoute
import com.example.applist.presentation.view.appDetails.AppDetailsScreen
import com.example.applist.presentation.view.appList.AppListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val repository = remember { AppDetailsRepositoryImpl(AppDetailsLocalDataSource()) } // TODO: сюда DI надо

    NavHost(
        navController = navController,
        startDestination = AppListRoute
    ) {
        composable<AppListRoute> {
            val vm: AppListViewModel = viewModel(
                factory = AppListViewModel.factory(repository)
            )
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

        composable<AppDetailsRoute> { val vm: AppDetViewModel = viewModel(
            factory = AppDetViewModel.factory(repository)
        )
            val state by vm.uiState.collectAsState()

            state.app?.let { app ->
                AppDetailsScreen(
                    appDetails = app,
                    similarApps = state.similarApps,
                    onBack = { navController.popBackStack() },
                    onOpenAppDetails = { navController.navigate(AppDetailsRoute(it.id)) },
                    onSimilarAppDownloadClick = {},
                    onReadMoreClick = {}
                )
            }
        }
    }
}