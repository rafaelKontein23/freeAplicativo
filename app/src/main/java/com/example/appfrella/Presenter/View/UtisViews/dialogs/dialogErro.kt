package com.example.appfrella.Presenter.View.UtisViews.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun DialogErro(
    primaryAction: () -> Unit,
){

    Dialog(
        onDismissRequest = { primaryAction() },
        properties = DialogProperties(
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {

        Column (
            modifier = Modifier
                .fillMaxWidth(.35f)
                .fillMaxHeight(.25f)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
        ) {

        }

    }

}


@Preview (showBackground = true)
@Composable
fun DialogErroPreview(){
    DialogErro(primaryAction = {})
}