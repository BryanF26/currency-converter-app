import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currency_converter_app.ui.home.CurrencyRateHome

class HomeViewModel : ViewModel() {

    private val _currencyRateHome = MutableLiveData<List<CurrencyRateHome>>()
    val currencyRateHome: LiveData<List<CurrencyRateHome>> get() = _currencyRateHome

    init {
        // Load historical data for currency rates (could be from API, database, etc.)
        loadCurrencyRateHome()
    }

    private fun loadCurrencyRateHome() {
        // Simulated currency rate home data
        _currencyRateHome.value = listOf(
            CurrencyRateHome("flag_usd_circle","USD", "United States Dollar", "1 USD = 15196.90 IDR"),
            CurrencyRateHome("flag_usd_circle","USD", "United States Dollar", "1 USD = 0.90 EUR"),
            CurrencyRateHome("flag_eur_circle","EUR", "Euro", "1 EUR = 1.11 USD"),
            CurrencyRateHome("flag_eur_circle","EUR", "Euro", "1 EUR = 16827.80 IDR"),
            CurrencyRateHome("flag_idr_circle","IDR", "Indonesian Rupiah", "1 IDR = 0.000066 EUR"),
            CurrencyRateHome("flag_idr_circle","IDR", "Indonesian Rupiah", "1 IDR = 0.000059 USD"),
        )
    }
}
