package com.example.applist.model.navigation

import kotlinx.serialization.Serializable

@Serializable
object AppListRoute

@Serializable
data class AppDetailsRoute(val appId: String)