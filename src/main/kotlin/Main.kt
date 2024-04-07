import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


class AppState {
   val text = mutableStateOf("")
   val buttonEnabled: Boolean
      get() = text.value.isNotEmpty()
}
@Composable
@Preview
fun App(appState: AppState) {
//   var text by remember { mutableStateOf("") }
//   val message = buldMessage(text)
//   val buttonEnabled = text.isNotEmpty()

   MaterialTheme {
      Column {
         TextField(value = appState.text.value, onValueChange = { appState.text.value = it })
         Text(text = buildMessage(appState.text.value))
         Button(onClick = {appState.text.value = "" }, enabled = appState.buttonEnabled) {
            Text("Clean")
         }
      }
   }
}

fun buildMessage(message: String) = "Hello $message!"

fun main() {
   val state = AppState()
   application {
      Window(onCloseRequest = ::exitApplication) {
         App(state)
      }
   }
}


