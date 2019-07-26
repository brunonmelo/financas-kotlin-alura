package br.com.alura.financask.extrension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.converteCurrency(): String {
    val currencyInstance = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
    return currencyInstance.format(this)
}