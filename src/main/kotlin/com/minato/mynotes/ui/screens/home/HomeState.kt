package com.minato.mynotes.ui.screens.home

import com.minato.mynotes.data.Filter
import com.minato.mynotes.data.Note
import com.minato.mynotes.data.getNotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

object HomeState {
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

   fun onFilterClick(filter: Filter) {
      _state.update { it.copy(filter = filter) }
   }

   data class UiState(
      var notes: List<Note>? = null,
      val loading: Boolean = false,
      val filter: Filter = Filter.All
   ) {
      val filterNotes: List<Note>?
         get() = when (filter) {
            Filter.All -> notes
            is Filter.ByType -> notes?.filter {
               it.type == filter.type
            }
         }
   }
}



