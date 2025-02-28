package com.example.appfrella.Presenter.View.UtisViews.Mascaras

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation


class MascaraCelular : MascarasProjeto {
    override fun filter(text: AnnotatedString): TransformedText {
        val originalText = text.text.filter { it.isDigit() } // Remove caracteres não numéricos

        val maskedText = buildString {
            for (i in originalText.indices) {
                append(originalText[i])
                when (i) {
                    1 -> append(" ") // Espaço após o DDD
                    6 -> if (originalText.length > 7) append("-") // Hífen para 9 dígitos
                    5 -> if (originalText.length == 7) append("-") // Hífen para 8 dígitos
                }
            }
        }

        return TransformedText(
            AnnotatedString(maskedText),
            CelularOffsetMapping(originalText)
        )
    }

    class CelularOffsetMapping(private val originalText: String) : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <= 6) return offset + 1
            if (originalText.length > 7) {
                return offset + 2
            } else if (originalText.length == 7) {
                return offset + 1
            }
            return offset
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 8) return offset - 1
            return offset - 2
        }
    }
}
