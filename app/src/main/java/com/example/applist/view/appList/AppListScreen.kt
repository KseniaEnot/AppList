package com.example.applist.view.appList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applist.model.appDetails.AppDetails


@Composable
fun AppListScreen(
    appDetailList: List<AppDetails>,
    onAppClick: (AppDetails) -> Unit,
    onBack: () -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier
){
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding))
        {
            ToolBar(
                onBack,
                onSearch,
                Modifier.background(MaterialTheme.colorScheme.primary)
                    .padding(10.dp)
                    .fillMaxWidth())
            AppList(appDetailList,
                { onAppClick(it) },
                Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(10.dp))
        }
    }
}
