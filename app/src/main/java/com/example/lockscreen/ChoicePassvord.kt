package com.example.lockscreen

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lockscreen.databinding.ActivityChoicePassvordBinding

class ChoicePassvord: AppCompatActivity() {
    private lateinit var bindingClass: ActivityChoicePassvordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityChoicePassvordBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        // запрет на поворот экрана
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        pref = getSharedPreferences(CONST_PASS.TABLE_PASS, Context.MODE_PRIVATE)
        enBut_Again_Ok_FALSE()
        arrSimplePass.clear()
    }

    private fun enableNubres_TRUE(){
            bindingClass.one2.isEnabled = true
            bindingClass.two2.isEnabled = true
            bindingClass.three2.isEnabled = true
            bindingClass.four2.isEnabled = true
            bindingClass.five2.isEnabled = true
            bindingClass.six2.isEnabled = true
            bindingClass.seven2.isEnabled = true
            bindingClass.eight2.isEnabled = true
            bindingClass.nine2.isEnabled = true
            bindingClass.zero2.isEnabled = true
    }

    private fun enableNubres_FALSE(){
        bindingClass.one2.isEnabled = false
        bindingClass.two2.isEnabled = false
        bindingClass.three2.isEnabled = false
        bindingClass.four2.isEnabled = false
        bindingClass.five2.isEnabled = false
        bindingClass.six2.isEnabled = false
        bindingClass.seven2.isEnabled = false
        bindingClass.eight2.isEnabled = false
        bindingClass.nine2.isEnabled = false
        bindingClass.zero2.isEnabled = false
    }


    private fun enBut_Again_Ok_TRUE(){
        bindingClass.againButton.isEnabled = true
        bindingClass.nextButton.isEnabled = true
    }
    private fun enBut_Again_Ok_FALSE(){
        bindingClass.againButton.isEnabled = false
        bindingClass.nextButton.isEnabled = false
    }


    fun onClickOne2(view: View) {
        arrSimplePass.add(1)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickTwo2(view: View) {
        arrSimplePass.add(2)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickThree2(view: View) {
        arrSimplePass.add(3)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickFour2(view: View) {
        arrSimplePass.add(4)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickFive2(view: View) {
        arrSimplePass.add(5)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickSix2(view: View) {
        arrSimplePass.add(6)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickSeven2(view: View) {
        arrSimplePass.add(7)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickIeght2(view: View) {
        arrSimplePass.add(8)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickNine2(view: View) {
        arrSimplePass.add(9)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickZero2(view: View) {
        arrSimplePass.add(0)
        if (arrSimplePass.size >= 5) {
            enableNubres_FALSE()
            enBut_Again_Ok_TRUE()
        }
        else{
            enableNubres_TRUE()
            enBut_Again_Ok_FALSE()
        }
    }

    fun onClickAgain(view: View) {
        arrSimplePass.clear()
        deleteAllPass()
        enBut_Again_Ok_FALSE()
        arrSimplePass.clear()
        enableNubres_TRUE()
    }

    fun onClickNext(view: View) {
        saveDataPass()
        val intent = Intent(this, ChoiceAlgorithm::class.java)
        arrSimplePass.clear()
        startActivity(intent)
        finish()
    }

}