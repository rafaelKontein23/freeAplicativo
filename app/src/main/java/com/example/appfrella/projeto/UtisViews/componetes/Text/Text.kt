package com.example.appfrella.projeto.UtisViews.componetes.Text

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfrella.R


@Composable
fun TextTituloInput(titulo: String) {

    Text(
        text = titulo, style = TextStyle(
            fontSize = 14.sp,
            color = Color(0xFF787B82),
            fontFamily = FontFamily(Font(R.font.manrope, FontWeight.Normal)),
            letterSpacing = 0.15.sp,
        ), modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun TextTituloDialog(titulo: String) {

    Text(
        text = titulo, style = TextStyle(
            fontSize = 16.sp,
            color = Color(0xFF000000),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.manrope)),
            letterSpacing = 0.15.sp,
        ), modifier = Modifier
            .padding(bottom = 24.dp, start = 24.dp, top = 32.dp)
            .fillMaxWidth(.9f)

    )
}

@Composable
fun TextSelecao(titulo: String, selecionado:Boolean, function: () -> Unit){

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)
            .background(Color(0xFFFFFFFF)).clickable {
                function()
            }
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFFFF))
        ){
            if(selecionado){
                Image(
                    painter = painterResource(R.drawable.check),
                    modifier = Modifier.fillMaxWidth(.1f),
                    contentDescription = "seta Selecionar",
                )
            }

            Text(
                text = titulo,
                modifier = Modifier.fillMaxWidth(.8f),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = if(selecionado ){
                        Color(0xFF5B6BFF)
                    }else{
                        Color(0xFF787B82)
                    },
                    fontFamily = FontFamily(Font(R.font.manrope, FontWeight.Normal)),
                    letterSpacing = 0.15.sp
                )
            )
        }

        Row(
            modifier = Modifier.height(1.dp).fillMaxWidth()
        ){}
    }


}

@Composable
fun TextModal(titulo: String ){
    Text(
        text = titulo,
        style = TextStyle(
            fontSize = 24.sp,
            color = Color(0xFF000000),
            fontFamily = FontFamily(Font(R.font.manrope_bold)),
            letterSpacing = 0.15.sp,
        ),
        modifier =  Modifier.padding(top = 32.dp)

    )
}


@Composable
fun TextDescricao(descricao:String){

    Text(
        text = descricao,
        style = TextStyle(
            fontSize = 13.sp,
            color = Color(0xFF787B82),
            fontWeight = FontWeight(400),
            fontFamily = FontFamily(Font(R.font.manrope)),
            letterSpacing = 0.15.sp,
            textAlign =  TextAlign.Center
        ),
        modifier =  Modifier.padding(top = 12.dp, start = 24.dp, end = 16.dp)

    )

}

@Composable
fun TextPlaceHolderInput(placeHolder: String) {
    Text(
        text = placeHolder,
        modifier = Modifier.fillMaxWidth(.88f),
        color = Color(0xFF787B82),
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.manrope))
    )
}

@Composable
fun TextSelect(titulo: String,slecionado:String, function: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)
            .background(Color(0xFFFFFFFF))
    ) {
        TextTituloInput(titulo)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFFFF))
                .padding(top = 8.dp)
                .border(width = 1.dp, color = Color(0xFFADB0B6), shape = RoundedCornerShape(8.dp))
                .clickable {
                    function()
                }
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,

            ) {

            Text(
                text = slecionado,
                modifier = Modifier.weight(.8f),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF787B82),
                    fontFamily = FontFamily(Font(R.font.manrope, FontWeight.Normal)),
                    letterSpacing = 0.15.sp
                ),
            )

            Image(
                painter = painterResource(R.drawable.seta_baixo),
                contentDescription = "seta Selecionar",
                modifier = Modifier.size(24.dp)

            )
        }

    }

}


@Composable
fun TextTiTuloInfo(){
    Text(
        text =  "Bem-Vindo(a)",
        style = TextStyle(
            fontSize = 32.sp,
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.manrope))
        )
    )
}

@Composable
fun TextDescricaoCompose(){
    Text(
        text =  "Conecte-se para explorar novas oportunidades, gerenciar seus projetos e crescer na sua carreira freelancer.",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color(0xD2FFFFFF),
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.manrope)),
            letterSpacing = 0.25.sp

        )
    )
}


@Composable
@Preview
fun TextTiTuloInfoPreview(){
    TextTiTuloInfo()
}

@Composable
@Preview
fun TextDescricaoComposePreview(){
    TextDescricaoCompose()
}

@Preview
@Composable
fun TextSelecaoPreview() {
    TextSelecao("Cidade", false){

    }
}

@Preview
@Composable
fun TextTituloInputPreview() {
    TextTituloInput("Nome")
}

@Preview
@Composable
fun TextSelectPreview() {
    TextSelect( "Cidade", "Cidade") {

    }
}

@Preview
@Composable
fun TextPlaceHolderInputPreview() {
    TextPlaceHolderInput("Endereço")
}

@Preview
@Composable
fun TextTituloDialogPreview() {
    TextTituloDialog("Cidade")
}

@Preview
@Composable
fun TextModalPreview() {
    TextModal("Opsss!")
}

@Preview
@Composable
fun TextDescricaoPreview() {
    TextDescricao("")

}