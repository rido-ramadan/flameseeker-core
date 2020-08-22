package com.edgardrake.flameseeker.core.utils

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 21-Aug-20
 */
 
fun CharSequence?.isNumber(): Boolean = this?.matches(Regex("\\d+(\\.\\d+)*")) ?: false

fun CharSequence?.isDecimal(): Boolean = this?.matches(Regex("\\d+\\.\\d+")) ?: false

fun CharSequence?.isDP(): Boolean = this?.matches(Regex("\\d+(dp)")) ?: false

fun CharSequence?.isSP(): Boolean = this?.matches(Regex("\\d+(sp)")) ?: false

fun CharSequence?.toDP(): Int? = this.toString().toIntOrNull()?.dp

fun CharSequence?.toSP(): Int? = this.toString().toIntOrNull()?.sp