package com.example.lockscreen

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.lockscreen.databinding.ActivityChoiceAlgorithmBinding

class ChoiceAlgorithm : AppCompatActivity() {
    private lateinit var bindingClass: ActivityChoiceAlgorithmBinding
    private var tmpS = ""
    private var choiceDone = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityChoiceAlgorithmBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        // запрет на поворот экрана
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        pref = getSharedPreferences(CONST_PASS.TABLE_PASS, Context.MODE_PRIVATE)


    }



    fun onClickMULTIPLY(view: View){
        tmpS = CONST_PASS.MULTIPLY
        choiceDone = true
    }


    fun onClickADDITION(view: View){
        choiceDone = true
        tmpS = CONST_PASS.ADDITION
    }


    fun onClickSUBTRACTION(view: View){
        choiceDone = true
        tmpS = CONST_PASS.SUBTRACTION
    }

    fun onClickDIVISION(view: View){
        choiceDone = true
        tmpS = CONST_PASS.DIVISION
    }

    fun onClickFinish(view: View){
        if (!choiceDone){
            Toast.makeText(this,
                "Выберите арефметическую операцию",
                Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(bindingClass.inputNumber.text.toString()) &&
            TextUtils.isDigitsOnly(bindingClass.inputNumber.text.toString()))
            bindingClass.inputNumber.error = "Введите число 1 до 300 (включительно)"
        else{
            if(bindingClass.inputNumber.text.toString().toInt() in 1..300) {
                val editor = pref.edit()
                editor?.putString(CONST_PASS.OPERATION, tmpS)
                editor?.putInt(
                    CONST_PASS.USER_NUMBER,
                    bindingClass.inputNumber.text.toString().toInt()
                )
                editor?.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
                bindingClass.inputNumber.error = "Введите число 1 до 300 (включительно)"
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, ChoicePassvord::class.java)
        startActivity(intent)
        finish()
    }


}