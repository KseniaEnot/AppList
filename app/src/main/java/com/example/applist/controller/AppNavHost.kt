package com.example.applist.controller

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.applist.view.appDetails.AppDetailsScreen
import com.example.applist.view.appList.AppListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppListRoute
    ) {
        composable<AppListRoute> {
            AppListScreen(
                appDetailList = getTestAppsList(),
                onAppClick = { app ->
                    navController.navigate(AppDetailsRoute(app.id))
                },
                onBack={ navController.popBackStack() },
                onSearch={},
            )
        }

        composable<AppDetailsRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<AppDetailsRoute>()
            val app = getTestAppsList().first { it.id == route.appId }

            AppDetailsScreen(
                appDetails = app,
                onBack = { navController.popBackStack() },
                onOpenAppDetails = { similarApp ->
                    navController.navigate(AppDetailsRoute(similarApp.id))
                },
                onSimilarAppDownloadClick = { /* ... */ },
                onReadMoreClick = {}
            )
        }
    }
}