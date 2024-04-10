import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.concurrent.thread

object AppState {
   var state by mutableStateOf(UiState())

   fun loadNotes() {
      thread {
         state = state.copy(loading = true)
         getNotes { notes ->
            state = state.copy(notes = notes, loading = false)
         }
      }
   }

   data class UiState(
      var notes: List<Note>? = null,
      val loading: Boolean = false
   )
}



