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
        _currencyRateHistory.value = mutableListOf(
            CurrencyRateHistory("EUR", "USD", "1000.00 EUR = 1110.00 USD"),
            CurrencyRateHistory("IDR", "USD", "150.00 IDR = 0.01 USD"),
            CurrencyRateHistory("USD", "IDR", "150 USD = 2279535.00 IDR")
        )
    }

    fun addCurrencyRateHistory(fromCurrency: String, toCurrency: String, conversionResult: String) {
        val currentList = _currencyRateHistory.value?.toMutableList() ?: mutableListOf()
        currentList.add(CurrencyRateHistory(fromCurrency, toCurrency, conversionResult))
        _currencyRateHistory.value = currentList
    }
}
