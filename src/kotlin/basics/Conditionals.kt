package kotlin

fun main() {
    // ОПЕРАЦИИ ОТНОШЕНИЯ: ==, !=, >, <, >=, <=, === (равенство ссылок)

    // ЛОГИЧЕСКИЕ ОПЕРАЦИИ:
    val t = true
    val f = false
    var result: Boolean

    result = t and f  // логическое 'И'
    print("t and f = $result")

    result = t or f  // логическое 'ИЛИ'
    print(", t or f = $result")

    result = t xor f  // логическое 'ИСКЛЮЧАЮЩЕЕ ИЛИ'
    print(", t xor f = $result")

    result = !t  // логическое 'НЕ'
    print(", !t = $result")

    result = f.not()  // альтернативное логическое 'НЕ'
    print(", f.not() = $result")

    // x..y создаёт интервал (последовательность)
    result = 7 in 0..10  // 0 <= 7 <= 10 (in возвращает true если 7 находится в последовательности чисел от 0 до 10)
    println(", 7 in 0..10 = $result")


    // ЛОГИЧЕСКИЕ КОНСТРУКЦИИ:

    // укороченное логическое выражение (аналог тернарного оператора)
    val tXORf = if (t xor f) "true" else "false"  // возвращаемое значение может быть блоком кода заключённым в {}
    println("t xor f = $tXORf")

    // if-else
    var num = 2 * 4
    if (num == 10) {
        println("num равно 10")
    } else if (num > 10) {
        println("num больше 10")
    } else if (num < 10) {
        println("num меньше 10")
    } else {
        println("необрабатываемое значение num: $num")
        num = 10
        println("значение num установлено: $num")
    }

    // when - аналог switch. аргумент when может быть примитивом или String
    // при совпадении могут выполняться инструкции или возвращаться значение
    // если результат when присваивается переменной, то ветвь else обязательна
    val whenResult = when (val n = num + 5) {  // when может принимать динамически вычисляемые значения и объявлять val
        10, 20 -> "n = 10 или 20"  // сравнение с набором значений
        in Integer.MIN_VALUE..0 -> "n <= 0"  // сравнение с диапазоном значений
        num + 5 -> "n = num + 5"  // сравнение с динамически вычисляемым значением
        else -> {  // для каждого кейса можно использовать блок кода, если необходимо выполнить несколько инструкций
            println("необрабатываемое значение")
            "необрабатываемое значение. n = $n"
        }
    }
    println("whenResult: $whenResult")

    // when может применяться без аргументов, как аналог if-else
    when {
        (t and f) -> println("both are true")
        (t xor f) -> println("only one is true")
        else -> println("both are false")
    }
}