import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
@Preview
fun App(appState: AppState) {

   val notes = appState.state.value.notes

   if (notes == null) {
      LaunchedEffect(true) {
         appState.loadNotes()
      }
   }

   MaterialTheme {
      Box(
         contentAlignment = Alignment.Center,
         modifier = Modifier.fillMaxSize()
      ) {
         if (appState.state.value.loading) {
            CircularProgressIndicator()
         }

         if (notes != null) {
            NotesList(notes)
         }
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


