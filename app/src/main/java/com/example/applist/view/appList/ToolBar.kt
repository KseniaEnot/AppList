package com.example.applist.view.appList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.applist.R
import com.example.applist.model.appDetails.AppDetails
import com.example.applist.model.appDetails.Category
import com.example.applist.view.theme.AppListTheme

@Composable
fun ToolBar(appDetails: AppDetails?, modifier: Modifier = Modifier){
    Row(modifier = modifier
            .fillMaxWidth()) {
        AsyncImage(
            appDetails?.iconUrl,
            stringResource(R.string.app_with_name, R.string.icon, appDetails?.name.orEmpty()),
            Modifier.size(70.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(10.dp))

        val titleText = if (appDetails != null) {
            stringResource(R.string.app_with_name,R.string.app, appDetails.name)
        } else {
            stringResource(R.string.app)
        }
        Text(titleText)
    }
}

@Preview
@Composable
private fun Preview(){
    AppListTheme{
        ToolBar(AppDetails("1","bybyby","321","sad", Category.APP),
            Modifier.background(MaterialTheme.colorScheme.primary).padding(10.dp))
    }
}