package kotlin.basics

import java.util.*

// ВСЕ ПЕРЕМЕННЫЕ В KOTLIN - ССЫЛКИ НА ОБЪЕКТЫ.
// В некоторых случаях компилятор может заменять ссылочный тип на аналогичный примитив Java
// для обеспечения лучшей производительности

// Константа времени компиляции, должна быть инициализирована примитивом
// (Byte, Short, Int, Long, Float, Double, Boolean, Char) или String.
// Объявляется за пределами любых областей видимости (функций и классов).
const val LANGUAGE_NAME = "Kotlin"

/*
    Многострочный комментарий.
    Функция main - точка входа в программу.
*/
// принимающая аргументы main(args: Array<String>)
fun main() { // начало ф-ции main
    println("Hey, I'm learning Kotlin!")

    // Переменная - это именованный участок памяти, который хранит некоторое значение
    // Тип переменной выводится автоматически из присвоенного ей значения
    val immutableLocal = 42  // константа времени выполнения
    var mutableLocal = "text"  // изменяемая локальная переменная (можно присвоить другое значение)
    mutableLocal += " is here"
    val explicitTyped: Char  // явное указание типа (необходимо только при объявлении без инициализации)
    explicitTyped = 'A'
    println("$immutableLocal, $mutableLocal, $explicitTyped")

    val names = listOf("Andrey")
    names.plusElement("Sergey") // не будет добавлен, т.к. names - val, а List - неизменяемый тип
    println("names = $names")

    // беззнаковые числа инициализируется литералом с суффиксом U или u (НОВАЯ ЭКСПЕРИМЕНТАЛЬНАЯ ФИЧА)
    val uB: UByte = 255U  // 8 бит, значения от 0 до 2^8 - 1
    val uS: UShort = 65535U  // 16 бит, значения от 0 до 2^16 - 1
    val uI: UInt = 4_294_967_295U  // 32 бита, значения от 0 до 2^32 - 1
    val uL: ULong = 18_446_744_073_709_551_615U  // 64 бита, значения от 0 до 2^64 - 1
    val uL2 = 12987219347UL  // тип выводится из суффиксов
    println("UNSIGNED NUMBERS: uB = $uB, uS = $uS, uI = $uI, uL = $uL, uL2 = $uL2")

    val hex = 0x0A1  // 161 в шестнадцатеричной системе (от 0 до F)
    val binary = 0b101  // 5 в двоичной системе
    println("hex = $hex\nbinary = $binary")

    // последний бит используется для отражения знака числа
    // любой целочисленный литерал воспринимается как Int
    // Long инициализируктся литералом с суффиксом L
    val b: Byte = 127  // 8 бит, значения от -2^7 до 2^7 - 1
    val s: Short = 32767  // 16 бит, значения от -2^15 до 2^15 - 1
    val i: Int = 2_147_483_647  // 32 бита, значения от -2^31 до 2^31 - 1
    val l: Long = 9_223_372_036_854_775_807  // 64 бита, значения от -2^63 до 2^63 - 1

    // Любой литерал с плавающей точкой воспринимается как Double
    // Float инициализируется литералом с суффиксом F или f, деже с явным указанием типа переменной
    val f: Float = 3.14F  // 32 бита, значения от -3.4 * 10^38 до 3.4 * 10^38
    val d: Double = 7.62  // 64 бита, значения от ±5.0 * 10^324 до ±1.7 * 10^308
    val eD: Double = 5.45e21  // Double поддерживает экспоненциальную запись XeY = X * 10^Y
    val flag: Boolean = true  // ТОЛЬКО true или false (НЕ 1 и 0)
    val c: Char = 'C'  // 16 битные символы Юникода
    val specialC: Char = '\t'  // Char может содержать управляющие последовательности (эскейп-последовательности)
    val str: String = "this is a string"  // последовательность символов, теоретическая максимальная длина = Integer.MAX_VALUE

    // многострочная (""" ... """) шаблонная ($a или ${expression}) строка
    val multiLineTemplate: String = """
                MULTILINE TEMPLATE STRING:
                b = $b, s = $s, i = $i, l = $l
                f = $f, d = $d, eD = $eD, flag = $flag, c = $c, specialC = $specialC
                str = $str
                f * d = ${f * d}
            """.trimIndent()  // удаляет общий минимальный отступ и пустые строки в начале и конце текста
    println(multiLineTemplate)

    // Переменной типа Any можно присвоить любое значение
    var any: Any = "any var"
    if (any is String) any = any.capitalized()  // собственная функция-расширение (замена capitalize) для String
    print("any = $any")
    any = 981274937
    any *= 2
    println(", any = $any")

    println(11.inv())

}  // конец ф-ции main

/**
 * Replacement for Kotlin's deprecated `capitalize()` function.
 * A new extension function on String.
 */
fun String.capitalized(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.getDefault())
        else it.toString()
    }
}
