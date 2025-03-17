package com.example.appfrella.projeto.UtisViews

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgressBarCentralizao(
    verProgrres: Boolean,
) {
    AnimatedVisibility(visible = verProgrres) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
                .background(color = Color(0x41908F8F)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(64.dp)
                    .padding(bottom = 200.dp),
                color = Color.Blue,
                strokeWidth = 5.dp,
                trackColor = Color.LightGray
            )
        }
    }

}