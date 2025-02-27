package com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class MascaraCelular : MascarasProjeto {
    override fun filter(text: AnnotatedString): TransformedText {
        val mascaraCelular = text.text.mapIndexed{index,c ->
            when(index){
                0-> "($c"
                1 -> "$c) "
                2 -> "$c "
                6 -> "$c-"
                else -> c

            }
        }.joinToString(separator = "")
        return TransformedText(AnnotatedString(mascaraCelular),CepMascara)
    }

    object CepMascara: OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when{
                offset > 6 -> offset + 4
                offset > 4 -> offset + 2
                offset > 1 -> offset + 3
                offset > 0 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when{
                offset > 6 -> offset - 4
                offset > 4 -> offset - 2
                offset > 1 -> offset - 3
                offset > 0 -> offset - 1
                else -> offset
            }
        }

    }
}
