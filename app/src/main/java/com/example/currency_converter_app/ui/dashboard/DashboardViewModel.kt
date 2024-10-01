import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val exchangeRates = mapOf(
        "USD" to mapOf("IDR" to 15196.90, "EUR" to 0.90),
        "IDR" to mapOf("USD" to 0.000066, "EUR" to 0.000059),
        "EUR" to mapOf("USD" to 1.11, "IDR" to 16827.80)
    )

    fun getExchangeRate(fromCurrency: String, toCurrency: String, amount: Double): Double {
        val rate = exchangeRates[fromCurrency]?.get(toCurrency) ?: 0.0
        return amount * rate
    }

}
