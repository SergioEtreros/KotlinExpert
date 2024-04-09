import androidx.compose.runtime.MutableState

fun <T> MutableState<T>.update(produceNewValue: (T) -> T) {
   value = produceNewValue(value)
}