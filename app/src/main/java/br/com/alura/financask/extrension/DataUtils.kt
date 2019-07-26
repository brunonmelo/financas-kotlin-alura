package br.com.alura.financask.extrension

import java.text.SimpleDateFormat
import java.util.*


fun Calendar.formataParaBrasileiro(): String {
    val dataFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return dataFormat.format(this.time)
}