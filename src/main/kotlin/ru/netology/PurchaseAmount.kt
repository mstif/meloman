package ru.netology

import kotlin.math.roundToInt

const val PERCENT_FOR_REGULAR_DISCOUNT = 1 / 100.0
const val PERCENT_FOR_SECOND_DISCOUNT = 5 / 100.0
const val FIRST_DISCOUNT = 100
fun main() {
    val previousAmountCustomer = 15000
    val isRegularCustomer = true
    val totalAmount = 1500
    println(
        "Общая сумма покупки: $totalAmount , со скидкой: " +
                "${getAmountWithDiscount(totalAmount, previousAmountCustomer, isRegularCustomer)} рублей"
    )
}

fun getAmountWithDiscount(totalAmount: Int, previousAmount: Int, isRegularCustomer: Boolean): Int {
    val regularDiscount: Double = (if (isRegularCustomer) (1 - PERCENT_FOR_REGULAR_DISCOUNT) else 1.0)
    val result: Double =
        if (previousAmount <= 1000)
            totalAmount * regularDiscount
        else if (totalAmount <= FIRST_DISCOUNT) 0.0
        else if (previousAmount < 10000)
            (totalAmount - FIRST_DISCOUNT) * regularDiscount
        else (totalAmount - FIRST_DISCOUNT) * (1 - PERCENT_FOR_SECOND_DISCOUNT) * regularDiscount
    return result.roundToInt()

}