package com.example.appfrella.Presenter.View.cadastro.componetes.Input

import android.graphics.fonts.FontFamily
import android.renderscript.ScriptGroup.Input
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import com.example.appfrella.R

@Composable
fun InputComum( text: String, placeHolder: String = "Endereço", onTextChange: (String) -> Unit){


    BasicTextField(
        value = text,
        onValueChange = { onTextChange},
        textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(width = 1.dp, color = Color(0xFF929090), shape = RoundedCornerShape(8.dp))
            .background( Color(0xFFFFFFFF), shape = RoundedCornerShape(8.dp))
            .padding(22.dp),

        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                if (text.isEmpty()) {
                    Text(text = placeHolder, color = Color.Gray, fontSize = 16.sp)
                }
                innerTextField()
            }
        }
    )

}


@Preview(showBackground = false )
@Composable
fun inputComumPreview(){
    var text by remember { mutableStateOf("") }

    InputComum(text, onTextChange = { text = it })
}