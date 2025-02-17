package com.example.appfrella.Utis.extensoes

import android.widget.EditText
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

       fun EditText.mascaraCpf(){
           val listener = MaskedTextChangedListener(
               primaryFormat = "[000]{.}[000]{.}[000]{-}[00]",
               field = this,
               listener = null
           )
           this.addTextChangedListener(listener)
           this.onFocusChangeListener = listener
       }
       fun EditText.mascaraTelefone(){
           val listener = MaskedTextChangedListener(
               primaryFormat = "{(}[00]{) }[0]{ }[0000]{-}[0000]",
               field = this,
               listener = null
           )
           this.addTextChangedListener(listener)
           this.onFocusChangeListener = listener

       }

       fun String.removeMascara():String{
           var texto = this
           texto=   texto.replace("[.]".toRegex(), "")
               .replace("[-]".toRegex(), "")
               .replace("[/]".toRegex(), "")
               .replace("[(]".toRegex(), "")
               .replace("[)]".toRegex(), "")

           return texto
       }
   }

}