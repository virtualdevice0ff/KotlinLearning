package basics


/*
 Kotlin doesn't have its own library of collections so it uses Java collection classes,
 though those collections' functionality is extended in Kotlin.
 Collections in Kotlin can be mutable or immutable. Immutable ones are re-created instead of changing.
 All Kotlin collections are located in kotlin.collections package.

 Immutable collections:  Iterable -> kotlin.Collection -> List, Set + Map (doesn't extend Collection)
                         Functionality: size, isEmpty(), contains(element), containsAll(collection)

 Mutable collections:    MutableIterator -> kotlin.MutableCollection (extends Collection) -> MutableList, MutableSet
                         + MutableMap (doesn't extend MutableCollection)
                         Functionality: add(element), remove(element), addAll(elements), removeAll(elements), clear()
*/
fun main() {

    // LIST
    // initialization with listOf()
    val evenDigits = listOf(0, 2, 4, 6, 8)  // чётные
    var i = 0
    // initialization with class constructor List() using lambda as a values generator
    val oddDigits: List<Int> = List(5) { if (i++ % 2 == 1) i else i++ }  // нечётные

    println("evenDigits:\t$evenDigits")

    print("oddDigits:\t[")
    for (d in oddDigits.indices) {
        print("${oddDigits[d]}" + if (d != oddDigits.indices.last) ", " else "]")
    }
    println()

    val getIndex = evenDigits[3]
    val elementAt = evenDigits.elementAt(2)
    val elementAtOrNull = oddDigits.elementAtOrNull(7)
    val first = oddDigits.first()
    val last = oddDigits.last()
    val indexOf = oddDigits.indexOf(last)
    val lastIndexOf = oddDigits.lastIndexOf(first)
    val contains = oddDigits.contains(8)
    val containsAll = evenDigits.containsAll(oddDigits)
    val size = oddDigits.size
    val isEmpty = evenDigits.isEmpty()

    println("""
        getIndex = $getIndex,  elementAt = $elementAt,  elementAtOrNull = $elementAtOrNull
        first = $first,  last = $last,  indexOf = $indexOf,  lastIndexOf = $lastIndexOf
        contains = $contains,  containsAll = $containsAll,  size = $size,  isEmpty = $isEmpty
        """.trimIndent())


}