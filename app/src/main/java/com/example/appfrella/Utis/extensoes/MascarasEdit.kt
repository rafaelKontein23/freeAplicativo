package com.example.appfrella.Utis.extensoes

import android.widget.EditText
import com.redmadrobot.inputmask.MaskedTextChangedListener

class MascarasEdit {


    fun EditText.mascaraData(){
        // Criação do listener de máscara
        val listener = MaskedTextChangedListener(
            primaryFormat = "[00]{/}[00]{/}[0000]", // Máscara para DD/MM/YYYY
            field = this,
            listener = null // Listener opcional
        )

        // Adiciona o listener ao EditText
        this.addTextChangedListener(listener)

        // Configura o listener de foco
        this.onFocusChangeListener = listener
    }
}