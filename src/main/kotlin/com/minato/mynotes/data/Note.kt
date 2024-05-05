package com.minato.mynotes.data

import com.minato.mynotes.data.Note.Type
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class Note(val title: String, val description: String, val type: Type) {
   enum class Type { TEXT, AUDIO }
}

fun getNotes(): Flow<List<Note>> = flow {
   delay(1500)
   val notes = (0..10).map {
      Note(
         "Title $it",
         "Description $it",
         if (it % 3 == 0) Type.AUDIO else Type.TEXT
      )
   }
   emit(notes)
}

