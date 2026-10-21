package com.example.applist.controller

import com.example.applist.model.appDetails.AppDetails

fun getSimilarApps(appDetails: AppDetails): List<AppDetails>{
    return getTestAppsList() //TODO подтягивать с сети
        //.filter { it.category == appDetails.category && it.id != appDetails.id }
        //.sortedByDescending { it.rating }
        .take(9)
}