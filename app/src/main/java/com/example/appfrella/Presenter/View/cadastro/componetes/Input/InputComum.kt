package com.example.appfrella.Presenter.View.cadastro.componetes.Input

import android.renderscript.ScriptGroup.Input
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import com.example.appfrella.Presenter.View.cadastro.componetes.Text.TextPlaceHolderInput
import com.example.appfrella.Presenter.View.cadastro.componetes.Text.TextTituloInput
import com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras.MascaraCelular
import com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras.MascaraCep
import com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras.MascarasProjeto
import com.example.appfrella.R
import com.example.appfrella.Utis.extensoes.ValidarCampos.Companion.validaEmail


@Composable
fun InputTextComum(
    text: String,
    placeHolder: String = "Endereço..",
    titulo: String = "Endereço",
    onTextChange: (String) -> Unit,
    error: Boolean,
) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF))
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)
    ) {

        TextTituloInput(titulo)


        BasicTextField(
            value = text,
            onValueChange = { onTextChange(it) },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = if (error) {
                    Color(0xFFF53131)
                } else {
                    Color(0xFF000000)
                },
                fontFamily = FontFamily(Font(R.font.manrope))
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (error) {
                        Color(0xFFF53131)
                    } else {
                        Color(0xFFADB0B6)
                    },
                    shape = RoundedCornerShape(8.dp)
                )
                .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(8.dp))
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),

            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (text.isEmpty()) {
                            TextPlaceHolderInput(placeHolder)
                        }
                    }
                    innerTextField()
                }
            }
        )
    }
}


@Composable
fun InputTextBusca(
    text: String,
    placeHolder: String = "busque por cidades..",
    onTextChange: (String) -> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF))
            .padding(start = 24.dp, end = 24.dp)
    ) {

        BasicTextField(
            value = text,
            onValueChange = { onTextChange(it) },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color =
                Color(0xFF000000),
                fontFamily = FontFamily(Font(R.font.manrope))
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color(0xFFADB0B6),
                    shape = RoundedCornerShape(8.dp)
                )
                .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(8.dp))
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),

            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (text.isEmpty()) {
                            TextPlaceHolderInput(placeHolder)
                        }else{
                            TextPlaceHolderInput("")

                        }
                        Image(
                            painter = painterResource(R.drawable.buscar),
                            contentDescription = "seta Selecionar",
                            alignment = Alignment.CenterEnd,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}


@Composable
fun InputNumeroComum(
    text: String,
    onTextChange: (String) -> Unit,
    mascara: MascarasProjeto,
    maximoLetras: Int,
    titulo: String = "Número",
    placeHolder: String = "00000-000",
    error: Boolean
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF))
            .padding(start = 24.dp, end = 24.dp)
    ) {
        TextTituloInput(titulo)
        BasicTextField(
            value = text,
            onValueChange = {
                val filteredText = it.take(maximoLetras)
                onTextChange(filteredText)
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = if (error) {
                    Color(0xFFF53131)
                } else {
                    Color(0xFF000000)
                },
                fontFamily = FontFamily(Font(R.font.manrope))
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (error) {
                        Color(0xFFF53131)
                    } else {
                        Color(0xFFADB0B6)
                    }, shape = RoundedCornerShape(8.dp)
                )
                .background(color = Color(0xFFFFFF))
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (text.isEmpty()) {
                        TextPlaceHolderInput(placeHolder)
                    }
                }
                innerTextField()
            },
            visualTransformation = mascara,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun inputNumeroComumPreview() {
    var text by remember { mutableStateOf("") }
    InputNumeroComum(
        text,
        onTextChange = { text = it },
        MascaraCelular(),
        14,
        titulo = "Celular",
        placeHolder = "(00) 00000-0000",
        error = false
    )
}


@Preview(showBackground = false)
@Composable
fun inputStringComumPreview() {
    var text by remember { mutableStateOf("") }
    InputTextComum(text, onTextChange = { text = it }, error = false)
}

@Preview
@Composable
fun InputTextBuscaPreview() {
    var text by remember { mutableStateOf("") }
    InputTextBusca(text, onTextChange = { text = it })
}


