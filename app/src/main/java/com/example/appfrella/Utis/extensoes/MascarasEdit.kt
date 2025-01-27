package com.example.appfrella.Utis.extensoes

import android.widget.EditText
import com.example.appfrella.R
import com.redmadrobot.inputmask.MaskedTextChangedListener

class MascarasEdit {

    companion object {
        fun EditText.mascaraData(){
            val listener = MaskedTextChangedListener(
                primaryFormat = "[00]{/}[00]{/}[0000]",
                field = this,
                listener = null
            )

            this.addTextChangedListener(listener)

            this.onFocusChangeListener = listener
        }
        fun EditText.mascaraTelefone() {
            val listener = MaskedTextChangedListener(
                primaryFormat = "([00]) [00000]-[0000]",
                field = this,
                listener = null
            )

            this.addTextChangedListener(listener)

            if (this.onFocusChangeListener == null) {
                this.onFocusChangeListener = listener
            }
        }

        fun EditText.validaErro(error:Boolean, mesagemErro:String) {
            if (error) {
                this.error = mesagemErro
            }else{
                this.error = null
                this.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.certo, 0)

            }
        }
        fun EditText.mascaraCPF(){
            val listener = MaskedTextChangedListener(
                primaryFormat = "[000]{.}[000]{.}[000]{-}[00]",
                field = this,
                listener = null )
            this.addTextChangedListener(listener)
            this.onFocusChangeListener = listener
        }
    }

}