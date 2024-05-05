package com.minato.mynotes.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minato.mynotes.data.Note

@Composable
fun NotesList(notes: List<Note>) {
   LazyColumn(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      items(notes) { note ->
         Card(
            modifier = Modifier
               .padding(8.dp)
               .fillMaxWidth(0.8F)
         ) {
            Column(
               modifier = Modifier.padding(16.dp)
            ) {
               Row {
                  Text(
                     text = note.title,
                     style = MaterialTheme.typography.h6,
                     modifier = Modifier.weight(1F)
                  )

                  if (note.type == Note.Type.AUDIO) {
                     Icon(imageVector = Icons.Default.Mic, contentDescription = "escuchar audio")
                  }
               }
               Spacer(modifier = Modifier.height(8.dp))
               Text(note.description)
            }
         }
      }
   }
}