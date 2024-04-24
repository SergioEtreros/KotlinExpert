import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

object AppState {
   private var _state = MutableStateFlow(UiState())
   val state = _state.asStateFlow()

   fun loadNotes(coroutineScope: CoroutineScope) {

      coroutineScope.launch {
         _state.value = state.value.copy(loading = true)
         getNotes().collect {
            _state.value = state.value.copy(notes = it, loading = false)
         }
      }
   }

   data class UiState(
      var notes: List<Note>? = null,
      val loading: Boolean = false
   )
}



