import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

object AppState {
   var state by mutableStateOf(UiState())

   fun loadNotes(coroutineScope: CoroutineScope) {

      coroutineScope.launch {
         state = state.copy(loading = true)
         state = state.copy(notes = getNotes(), loading = false)
      }
   }

   data class UiState(
      var notes: List<Note>? = null,
      val loading: Boolean = false
   )
}



