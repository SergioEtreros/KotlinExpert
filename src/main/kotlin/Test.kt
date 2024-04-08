fun main() {
   val list: List<Note> = listOf(
      Note("Title 1", "Description 1", Note.Type.TEXT),
      Note("Title 2", "Description 2", Note.Type.TEXT),
      Note("Title 3", "Description 3", Note.Type.TEXT),
      Note("Title 4", "Description 4", Note.Type.TEXT),
      Note("Title 5", "Description 5", Note.Type.TEXT),
      Note("Title 6", "Description 6", Note.Type.TEXT),
   )

   val mutableList: MutableList<Note> = mutableListOf(
      Note("Title 1", "Description 1", Note.Type.TEXT),
      Note("Title 2", "Description 2", Note.Type.TEXT),
      Note("Title 3", "Description 3", Note.Type.TEXT),
      Note("Title 4", "Description 4", Note.Type.TEXT),
      Note("Title 5", "Description 5", Note.Type.TEXT),
      Note("Title 6", "Description 6", Note.Type.TEXT),
   )

   val set: Set<Note> = setOf(
      Note("Title 6", "Description 6", Note.Type.TEXT),
      Note("Title 4", "Description 4", Note.Type.TEXT),
      Note("Title 1", "Description 1", Note.Type.TEXT),
      Note("Title 2", "Description 2", Note.Type.TEXT),
      Note("Title 3", "Description 3", Note.Type.TEXT),
      Note("Title 3", "Description 3", Note.Type.TEXT),
      Note("Title 5", "Description 5", Note.Type.TEXT),
      Note("Title 4", "Description 4", Note.Type.TEXT),
   )

   val map = mutableMapOf( // Dos maneras distintas de crear el par
      1 to Note("Title 6", "Description 6", Note.Type.TEXT),
      2 to Note("Title 4", "Description 4", Note.Type.TEXT),
      Pair (3, Note("Title 1", "Description 1", Note.Type.TEXT)),
      4 to Note("Title 2", "Description 2", Note.Type.TEXT),
      Pair(5, Note("Title 3", "Description 3", Note.Type.TEXT)),
      6 to Note("Title 3", "Description 3", Note.Type.TEXT),
      7 to Note("Title 5", "Description 5", Note.Type.TEXT),
      8 to Note("Title 4", "Description 4", Note.Type.TEXT),
   )

   val emptyList: List<Note> = emptyList()
   val list2 = list + Note("Title 7", "Description 7", Note.Type.TEXT)
   mutableList.add(Note("Title 8", "Description 8", Note.Type.TEXT))

   map[9] = Note("Title 9", "Description 9", Note.Type.TEXT)

   val result = list.filterNot { it.title.contains('4') }
   val titles = list.sortedBy { it.title }.map { it.title }

   println(list)
   println(result)
   println(titles)
   println(list2)
   println(mutableList)
   println(set)
   println(map)
}