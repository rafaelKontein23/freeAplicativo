package com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText

class MascaraData : MascarasProjeto {
    override fun filter(text: AnnotatedString): TransformedText {
        val originalText = text.text

        // Aplica a máscara
        val mascaraData = buildString {
            for (i in originalText.indices) {
                append(originalText[i])
                if (i == 1 || i == 3) append("/") // Adiciona "/" nas posições certas
            }
        }

        return TransformedText(AnnotatedString(mascaraData), DataOffsetMapping)
    }

    object DataOffsetMapping : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset <= 1 -> offset
                offset in 2..3 -> offset + 1
                offset >= 4 -> offset + 2
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset <= 2 -> offset
                offset in 3..4 -> offset - 1
                offset >= 5 -> offset - 2
                else -> offset
            }
        }
    }
}