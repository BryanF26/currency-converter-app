import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currency_converter_app.ui.history.CurrencyRateHistory

class HistoryViewModel : ViewModel() {

    private val _currencyRateHistory = MutableLiveData<List<CurrencyRateHistory>>()
    val currencyRateHistory: LiveData<List<CurrencyRateHistory>> get() = _currencyRateHistory

    init {
        // Load historical data for currency rates (could be from API, database, etc.)
        loadCurrencyRateHistory()
    }

    private fun loadCurrencyRateHistory() {
        // Simulated currency rate history data
        _currencyRateHistory.value = listOf(
            CurrencyRateHistory("USD", "United States Dollar", "1 USD = 15,000 IDR"),
            CurrencyRateHistory("EUR", "Euro", "1 EUR = 16,000 IDR"),
            CurrencyRateHistory("GBP", "British Pound", "1 GBP = 18,000 IDR"),
            CurrencyRateHistory("JPY", "Japanese Yen", "1 JPY = 0.10 IDR"),
            CurrencyRateHistory("AUD", "Australian Dollar", "1 AUD = 10,000 IDR"),
            CurrencyRateHistory("CAD", "Canadian Dollar", "1 CAD = 11,500 IDR"),
            CurrencyRateHistory("CHF", "Swiss Franc", "1 CHF = 16,500 IDR"),
            CurrencyRateHistory("CNY", "Chinese Yuan", "1 CNY = 2,200 IDR"),
            CurrencyRateHistory("NZD", "New Zealand Dollar", "1 NZD = 9,000 IDR"),
            CurrencyRateHistory("SGD", "Singapore Dollar", "1 SGD = 11,000 IDR")
        )
    }
}
