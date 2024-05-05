package com.minato.mynotes

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.minato.mynotes.ui.App

fun main() {
   application {
      Window(onCloseRequest = ::exitApplication) {
         App()
      }
   }
}


