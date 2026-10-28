package com.example.applist.presentation.view.appList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.applist.R
import com.example.applist.domain.model.appDetails.AppDetails
import com.example.applist.domain.model.appDetails.Category

@Composable
fun AppList(appDetailList: List<AppDetails>,
            onSelect: (AppDetails) -> Unit,
            modifier: Modifier = Modifier){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier
    ) {
        items(appDetailList){ app ->
            Row(Modifier.clickable(onClick={onSelect(app)}))
            {
                AsyncImage(
                    app.iconUrl,
                    stringResource(R.string.app_with_name, stringResource(R.string.icon), app.name),
                    Modifier.size(56.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(10.dp))
                Column{
                    Text(app.name)
                    Text(stringResource(
                        getCategoryText(
                            app.category
                        )
                    ))
                    Text(app.description,
                        maxLines = 2)
                }
            }
        }
    }
}

@Composable
fun getCategoryText(category: Category): Int = when (category) {
    Category.APP -> R.string.category_app
    Category.GAME -> R.string.category_game
    Category.SOCIAL -> R.string.category_social
    Category.EDUCATION -> R.string.category_education
    Category.ENTERTAINMENT -> R.string.category_entertainment
    Category.MUSIC -> R.string.category_music
    Category.VIDEO -> R.string.category_video
}