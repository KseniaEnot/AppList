package com.example.applist.view.appDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applist.model.appDetails.AppDetails
import com.example.applist.view.SimilarApp.SimilarApps
import com.example.applist.view.appList.ToolBar

@Composable
fun AppDetailsScreen(appDetails: AppDetails,
                     similarApps : List<AppDetails>?,
                     onBack: () -> Unit,
                     onOpenAppDetails : (AppDetails) -> Unit,
                     onSimilarAppDownloadClick: (AppDetails) -> Unit,
                     onReadMoreClick : () -> Unit,
                     modifier: Modifier = Modifier)
{
    Scaffold(
        modifier = modifier
    )
    {
        innerPadding ->
        Column(
            //verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier.padding(innerPadding).verticalScroll(rememberScrollState())
        )
        {
            ToolBar(
                onBack,
                {}, // share
                Modifier.background(MaterialTheme.colorScheme.primary)
                    .padding(10.dp)
                    .fillMaxWidth()) // share
            Spacer(Modifier.height(8.dp))
            AppDetailsHeader(
                appDetails = appDetails,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(Modifier.height(8.dp))

            if (!similarApps.isNullOrEmpty()) {
                SimilarApps(
                    similarAppsList = similarApps,
                    onDownloadClick = onSimilarAppDownloadClick,
                    onOpenAppDetails = onOpenAppDetails,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            Spacer(Modifier.height(12.dp))
            AppDescription(
                description = appDetails.description,
                true, // TODO func to check if more when 1 str
                onReadMoreClick = onReadMoreClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }


    }
}
