@file:JvmName("PrimitiveUtils")
package com.edgardrake.flameseeker.core.utils

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 21-Aug-20
 */
 
fun CharSequence?.isNumber(): Boolean = this?.matches(Regex("\\d+(\\.\\d+)*")) ?: false

fun CharSequence?.isDecimal(): Boolean = this?.matches(Regex("\\d+\\.\\d+")) ?: false

fun CharSequence?.isDP(): Boolean = this?.matches(Regex("\\d+(dp)")) ?: false

fun CharSequence?.isSP(): Boolean = this?.matches(Regex("\\d+(sp)")) ?: false

fun CharSequence?.toDP(): Int? {
    this?.let {
        Regex("(\\d+)\\s*(dp)").find(this)?.let { match ->
            val (number, _) = match.destructured
            return number.toInt().dp
        }
    } ?: return null
}

fun CharSequence?.toSP(): Int? {
    this?.let {
        Regex("(\\d+)\\s*(sp)").find(this)?.let { match ->
            val (number, _) = match.destructured
            return number.toInt().sp
        }
    } ?: return null
}