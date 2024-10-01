package com.example.currency_converter_app.ui.dashboard

data class Currency(
    val currencyCode: String,
    val flag: Int
) {
    override fun toString(): String {
        return currencyCode
    }
}
