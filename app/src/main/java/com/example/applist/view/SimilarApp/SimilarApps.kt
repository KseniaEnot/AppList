package com.example.applist.view.SimilarApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applist.model.appDetails.AppDetails

@Composable
fun SimilarApps(similarAppsList: List<AppDetails>,
                onDownloadClick: (AppDetails) -> Unit,
                onOpenAppDetails: (AppDetails) -> Unit,
                modifier: Modifier = Modifier
){
    val pages = remember(similarAppsList) { similarAppsList.chunked(3) }
    val pagerState = rememberPagerState(pageCount = { pages.size })

    HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxWidth()
    ) { pageIndex ->
        val pageItems = pages[pageIndex]

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            pageItems.forEach { item ->
                SimilarAppItem(
                    app = item,
                    onDownloadClick = { onDownloadClick(item) },
                    onOpenAppDetails = { onOpenAppDetails(item)},
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
            }
        }
    }
}