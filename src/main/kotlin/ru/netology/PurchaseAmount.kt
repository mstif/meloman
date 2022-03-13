package ru.netology

import kotlin.math.roundToInt

const val PERCENT_FOR_REGULAR_DISCOUNT = 1
const val PERCENT_FOR_SECOND_DISCOUNT = 5
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
    val regularDiscount = (if (isRegularCustomer) (100 - PERCENT_FOR_REGULAR_DISCOUNT) else 100) / 100.0
    val result: Double = (if (previousAmount <= 1000)
        totalAmount
    else if (totalAmount <= FIRST_DISCOUNT) 0 else
        if (previousAmount < 10000)
            (totalAmount - FIRST_DISCOUNT)
        else (totalAmount - FIRST_DISCOUNT) * (100 - PERCENT_FOR_SECOND_DISCOUNT) / 100) * regularDiscount
    return result.roundToInt()

}