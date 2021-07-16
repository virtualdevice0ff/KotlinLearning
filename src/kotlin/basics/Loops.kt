package kotlin

fun main() {
    val str = "here is some string"
    var result = ""


    // ЦИКЛ FOR:

    // для каждого i в диапазоне индексов str
    for (i in str.indices) {
        if (i % 2 == 0 && str[i].isLetter()) {
            result += str[i].uppercase()
        } else {
            result += str[i]
        }
    }
    println(result)


    val range = 'A'..'Z' // последовательность можно присвоить переменной
    print("for (i in 'A'..'Z'):\t")
    for (i in range) {
        print("$i ")
    }
    println()

    print("for (i in 9 downTo 0 step 1):\t")
    for (i in 9 downTo 0 step 1) {
        print("$i  ")
    }
    println()

    print("for (i in 0 until 10 step 2):\t")
    for (i in 0 until 10 step 2) {
        print("$i  ")
    }
    println()

    println("Таблица умножения:")
    for (row in 1..9) {
        for (column in 1..9) {
            print("${row * column}\t")
        }
        println()
    }


    // ЦИКЛ WHILE:

    var x = 10
    print("while (x > 0):\t")
    // если условие ложно, то тело цикла не выполняется
    while (x > 0) {
        print("${x * x}  ")
        x--
    }
    println()

    x = 999
    print("do {...} while (x <= 9):\t")
    // do-while применяется, когда нужно, чтобы код цикла выполнился хотя бы раз, независимо от условия
    do {
        print("$x  ")
        x++
    } while (x !in 900..1000)  // если x НЕ (not in) находится в диапазоне 900-1000
    println()


    print("for (i in 0..0) with 'continue' and 'break':\t")
    for (i in 0..9) {
        if (i == 4) {
            print("continue  ")
            continue  // оператор continue переводит цикл на следующую итерацию, пропуская другие инструкции
        }
        if (i == 7) {
            print("break")
            break  // оператор break прерывает (завершает) выполнение цикла, выполняется следующая после него интсрукция
        }
        print("$i  ")
    }
    println()


    var digits = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    print("digits.forEach():\t")
    digits.forEach {
        print("${it * 2}  ")
    }
    println()
}