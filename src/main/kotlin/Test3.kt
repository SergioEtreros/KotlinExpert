import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ViewModel {
   private val _state: MutableStateFlow<Note> = MutableStateFlow( Note("Title 1", "Description 1", Note.Type.TEXT))
   val state: StateFlow<Note> = _state.asStateFlow()

   suspend fun update() {
      var count = 1
      while (true) {
         delay(2000)
         count++
         _state.value = Note("Title $count", "Description $count", Note.Type.TEXT)
      }
   }
}

fun main(): Unit = runBlocking {
   val viewModel = ViewModel()
   launch {
      viewModel.update()
   }
   viewModel.state.collect(::println)
}