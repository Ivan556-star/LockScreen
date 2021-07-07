package com.example.lockscreen
import android.content.SharedPreferences
import java.util.*

lateinit var pref : SharedPreferences
var arrSimplePass = Stack<Int>()

object CONST_PASS{
    val TABLE_PASS = "TABLE_SIMPLE_PASS"
    val FIRST_BUTTON = "FIRST_BUTTON"
    val SECOND_BUTTON = "SECOND_BUTTON"
    val THIRD_BUTTON = "THIRD_BUTTON"
    val FOURTH_BUTTON = "FOURTH_BUTTON"
    val FIFTH_BUTTON = "FIFTH_BUTTON"

    val OPERATION = "OPERATION" // для сохранения выбранной арефметической операции
    val MULTIPLY = "MULTIPLY"
    val ADDITION = "ADDITION"
    val DIVISION = "DIVISION"
    val SUBTRACTION = "SUBTRACTION"
    val USER_NUMBER = "USER_NUMBER" // для сохранения введённого числа пользователя
}


fun deleteAllPass(){
    val editor = pref.edit()
    editor?.clear()
    editor?.apply()
}

fun saveDataPass(){
    val editor = pref.edit()
    editor?.putInt(CONST_PASS.FIRST_BUTTON, arrSimplePass[0])
    editor?.putInt(CONST_PASS.SECOND_BUTTON, arrSimplePass[1])
    editor?.putInt(CONST_PASS.THIRD_BUTTON, arrSimplePass[2])
    editor?.putInt(CONST_PASS.FOURTH_BUTTON, arrSimplePass[3])
    editor?.putInt(CONST_PASS.FIFTH_BUTTON, arrSimplePass[4])
    editor?.apply()
}

fun fillArrPass(){
    arrSimplePass.clear()
    arrSimplePass.add(pref.getInt(CONST_PASS.FIRST_BUTTON, -1))
    arrSimplePass.add(pref.getInt(CONST_PASS.SECOND_BUTTON, -1))
    arrSimplePass.add(pref.getInt(CONST_PASS.THIRD_BUTTON, -1))
    arrSimplePass.add(pref.getInt(CONST_PASS.FOURTH_BUTTON, -1))
    arrSimplePass.add(pref.getInt(CONST_PASS.FIFTH_BUTTON, -1))
}


