package com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class MascaraCep : MascarasProjeto {
    override fun filter(text: AnnotatedString): TransformedText {
        val mascaraCep = text.text.mapIndexed { index, c ->
            when (index) {
                5 -> "-$c"
                else -> c.toString()
            }
        }.joinToString(separator = "")
        return TransformedText(AnnotatedString(mascaraCep), CepMascara)
    }

    object CepMascara : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset > 5 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset > 6 -> offset - 4

                else -> offset
            }
        }

    }

}
