import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.concurrent.thread

class AppState {
   val state = mutableStateOf(UiState())

   fun loadNotes() {
      thread {
         state.value = UiState(loading = true)
         getNotes {
            state.value = UiState(
               notes = it,
               loading = false
            )
         }
      }
   }

   data class UiState(
      var notes: List<Note> = emptyList(),
      val loading: Boolean = false
   )
}

@Composable
@Preview
fun App(appState: AppState) {

   LaunchedEffect(true) { appState.loadNotes() }

   MaterialTheme {
      Box(contentAlignment = Alignment.Center) {
         if (appState.state.value.loading) {
            CircularProgressIndicator()
         }
         NotesList(appState.state.value.notes)
      }
   }
}


fun main() {
   val state = AppState()
   application {
      Window(onCloseRequest = ::exitApplication) {
         App(state)
      }
   }
}


