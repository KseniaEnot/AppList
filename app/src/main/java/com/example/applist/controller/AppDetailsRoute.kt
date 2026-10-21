package com.example.applist.controller

import kotlinx.serialization.Serializable

@Serializable
object AppListRoute

@Serializable
data class AppDetailsRoute(val appId: String)