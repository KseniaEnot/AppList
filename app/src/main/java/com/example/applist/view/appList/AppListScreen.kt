package com.example.applist.view.appList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applist.model.appDetails.AppDetails
import com.example.applist.model.appDetails.Category
import com.example.applist.view.theme.AppListTheme


@Composable
fun AppListScreen(
    appDetailList: List<AppDetails>,
    modifier: Modifier = Modifier
){
    var selectedApp by remember { mutableStateOf<AppDetails?>(null)}

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            //verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier.padding(innerPadding))
        {
            ToolBar(selectedApp,
                Modifier.background(MaterialTheme.colorScheme.primary).padding(10.dp))
            AppList(appDetailList,
                { selectedApp = it },
                Modifier.background(MaterialTheme.colorScheme.secondary).padding(10.dp))
        }
    }
}

fun getTestAppsList(): List<AppDetails> = listOf(
    AppDetails("1","Name", "https://img.icons8.ru/color/1200/google-logo.jpg", "Description (some text with different information about app)", Category.APP),
    AppDetails("2","SecondName", "https://opis-cdn.tinkoffjournal.ru/mercury/logo-for-business-01.vhhmmr.jpg", "321Description (some text with different information about app)", Category.GAME),
    AppDetails("3","Last?Name", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaGPMHMf6hE5VUbYsUNKyWATbsiGZIEFUVGyEZfnUSCfqiAXHKJvLgX0PP&s=10", "555Description (some text with different information about app)", Category.EDUCATION),
)



@Preview
@Composable
private fun Preview(){
    AppListTheme{
        AppListScreen(getTestAppsList())
    }
}