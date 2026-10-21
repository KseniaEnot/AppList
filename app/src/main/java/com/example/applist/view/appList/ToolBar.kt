package com.example.applist.view.appList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.res.stringResource
import com.example.applist.R

@Composable
fun ToolBar(onBack: () -> Unit, onRightButton : () -> Unit, modifier: Modifier = Modifier
    ){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier) {
        IconButton(
            onClick = onBack) {
            Icon(
               imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back)
            )
        }
        Button(onClick = onRightButton) { }
    }
}
