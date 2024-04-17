import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
   val res = flow {
      emit(1)
      delay(2000)
      emit(2)
      delay(2000)
      emit(3)
      delay(2000)
      emit(4)
      delay(2000)
      emit(5)
      delay(2000)
      emit(6)
      delay(2000)
      emit(7)
   }.transform {
      if (it % 2 == 0) {
         emit(it)
      }
   }

   launch {
      res.collect { println(it) }
   }

   val flow1 = flowOf(1, 2, 3, 4).onEach { delay(300) }
   val flow2 = flowOf("a", "b", "c").onEach { delay(500) }

   flow1.zip(flow2) { a, b -> "$a -> $b" }.collect { println(it) }


   flow1.combine(flow2) { a, b -> "$a -> $b" }.collect { println(it) }
}