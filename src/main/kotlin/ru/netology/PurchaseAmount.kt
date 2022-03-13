package ru.netology

import kotlin.math.roundToInt

const val percentForRegularFee = 1
const val percentForSecondFee = 5
const val firstFee = 100
fun main() {
    val previousAmountCustomer = 15000
    val isRegularCustomer = true
    val totalAmount = 150
    println(
        "Общая сумма покупки: $totalAmount , со скидкой: " +
                "${getAmountWithFee(totalAmount, previousAmountCustomer, isRegularCustomer)} рублей"
    )
}

fun getAmountWithFee(totalAmount: Int, previousAmount: Int, isRegularCustomer: Boolean): Int {
    val regularFee = (if (isRegularCustomer) (100 - percentForRegularFee) else 100) / 100.0
    val result: Double = (if (previousAmount <= 1000)
        totalAmount
    else if (totalAmount <= firstFee) 0 else
        if (previousAmount < 10000)
            (totalAmount - firstFee)
        else (totalAmount - firstFee) * (100 - percentForSecondFee) / 100) * regularFee
    return result.roundToInt()

}