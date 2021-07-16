package kotlin.basics

fun main() {
    // встроенная ф-ция arrayOf() принимает набор значений
    val strings: Array<String> = arrayOf("Hello!", "I'm", "learning", "Kotlin.")

    // Array() - конструктор класса Array
    // при объявлении с инициализацией тип можно не указывать, он выведется автоматически
    var numbers = Array(3) { 5 }  // массив из 3-х элементов [5, 5, 5], лямбда генерирует элементы массива
    println("numbers:  ${numbers.contentToString()}")

    var i = 1
    numbers = Array(4) {i++ * 2}  // лямбда-генератор может содержать более сложные инструкции
    println("numbers:  ${numbers.contentToString()}")

    // свойство indices содержит набор всех индексов массива
    if (1 in strings.indices) {  // проверка на ArrayIndexOutOfBoundsException
        strings[1] = "I am"  // присвоение значения элементу по индексу с помощью метода set, представленного []
    }

    // перебор элементов массива
    print("перебор массива в цикле for:\t")
    for (str in strings) {
        print("$str ")
    }
    println()

    i = 0
    print("перебор массива в цикле while:\t")
    while (i in numbers.indices) {
        print("${numbers[i]} ")
        i++
    }
    println()

    println("4 !in numbers: ${4 !in numbers}")  // проверка наличия или НЕналичия элемента в массиве

    // для каждого примитивного типа есть свой дополнительный тип массива:
    // ByteArray, ShortArray, IntArray, LongArray, FloatArray, DoubleArray, BooleanArray, CharArray
    // + функция для создания массива
    val ints: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val doubles = DoubleArray(3) {1.5}  // применение конструктора класса
    println("ints: ${ints.contentToString()}" +
            "\ndoubles: ${doubles.contentToString()}")


    // ДВУМЕРНЫЕ МАССИВЫ
    val sample = "ABC"
    val table: Array<Array<String>> = Array(3){Array(4){sample}}
    printTable(table)

    table[0] = arrayOf("first", "second", "third", "fourth")  // присвоить 1-й массив
    table[1][2] = "table[1][2]"  // [1][2] - 2-й массив, 3-й элемент (слева направо)
    printTable(table)


    println("перебор двумерного массива с помощью вложенного цикла:")
    for(row in table) {  // для каждой строки в таблице
        for(cell in row){  // для каждой ячейки в строке
            print("$cell  ")
        }
        println()  // перевести строку
    }

}


private fun printTable(table: Array<Array<String>>) {
    print("table:  ")
    table.forEach { print(it.contentToString()) }
    println()
}