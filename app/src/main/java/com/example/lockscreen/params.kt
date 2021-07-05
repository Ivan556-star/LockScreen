package com.example.lockscreen
import android.content.SharedPreferences
import java.util.*

lateinit var pref : SharedPreferences
var arrSimplePass = Stack<Int>()

object CONST_SIMPLE_PASS{
    val TABLE_SIMPLE_PASS = "TABLE_SIMPLE_PASS"
    val FIRST_BUTTON = "FIRST_BUTTON"
    val SECOND_BUTTON = "SECOND_BUTTON"
    val THIRD_BUTTON = "THIRD_BUTTON"
    val FOURTH_BUTTON = "FOURTH_BUTTON"
    val FIFTH_BUTTON = "FIFTH_BUTTON"
}

fun deleteAllSimplePass(){
    val editor = pref.edit()
    editor?.clear()
    editor?.apply()
}

fun saveDataSimplePass(){
    val editor = pref.edit()
    editor?.putInt(CONST_SIMPLE_PASS.FIRST_BUTTON, arrSimplePass[0])
    editor?.putInt(CONST_SIMPLE_PASS.SECOND_BUTTON, arrSimplePass[1])
    editor?.putInt(CONST_SIMPLE_PASS.THIRD_BUTTON, arrSimplePass[2])
    editor?.putInt(CONST_SIMPLE_PASS.FOURTH_BUTTON, arrSimplePass[3])
    editor?.putInt(CONST_SIMPLE_PASS.FIFTH_BUTTON, arrSimplePass[4])
    editor?.apply()
}

fun fillArrSimplePass(){
    arrSimplePass.clear()
    arrSimplePass.add(pref.getInt(CONST_SIMPLE_PASS.FIRST_BUTTON, -1))
    arrSimplePass.add(pref.getInt(CONST_SIMPLE_PASS.SECOND_BUTTON, -1))
    arrSimplePass.add(pref.getInt(CONST_SIMPLE_PASS.THIRD_BUTTON, -1))
    arrSimplePass.add(pref.getInt(CONST_SIMPLE_PASS.FOURTH_BUTTON, -1))
    arrSimplePass.add(pref.getInt(CONST_SIMPLE_PASS.FIFTH_BUTTON, -1))
}


