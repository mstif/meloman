package ru.netology

import kotlin.math.roundToInt

const val percentForRegularDiscount = 1
const val percentForSecondDiscount = 5
const val firstDiscount = 100
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
    val regularDiscount = (if (isRegularCustomer) (100 - percentForRegularDiscount) else 100) / 100.0
    val result: Double = (if (previousAmount <= 1000)
        totalAmount
    else if (totalAmount <= firstDiscount) 0 else
        if (previousAmount < 10000)
            (totalAmount - firstDiscount)
        else (totalAmount - firstDiscount) * (100 - percentForSecondDiscount) / 100) * regularDiscount
    return result.roundToInt()

}