import Note.Type

data class Note(val title: String, val description: String, val type: Type) {
   enum class Type { TEXT, AUDIO }
}

fun getNotes(callback: (List<Note>) -> Unit) {

   val notes = (1..10).map {
      Note(
         "Title $it",
         "Description $it",
         if (it % 3 == 0) Type.AUDIO else Type.TEXT
      )
   }
   Thread.sleep(2000)
   callback(notes)
}

