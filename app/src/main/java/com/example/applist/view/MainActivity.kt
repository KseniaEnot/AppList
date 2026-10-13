package com.example.applist.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.applist.view.theme.AppListTheme
import com.example.applist.view.appList.AppListScreen
import com.example.applist.view.appList.getTestAppsList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppListTheme {
                AppListScreen(getTestAppsList())
            }
        }
    }
}