package com.example.lockscreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import com.example.lockscreen.databinding.ActivityMainBinding
import java.util.*


class MainActivity: AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding
    var tmpArr = Stack<Int>()


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        pref = getSharedPreferences(CONST_SIMPLE_PASS.TABLE_SIMPLE_PASS, Context.MODE_PRIVATE)

        if (pref.getInt(CONST_SIMPLE_PASS.FIRST_BUTTON, -1) == -1){
            val intent = Intent(this@MainActivity, ChoicePassvord::class.java)
            startActivity(intent)
            finish()
        }

        fillButtons()
        fillArrSimplePass()


        // обработка удерживания кнопки DELETE
        bindingClass.delete.setOnTouchListener(object : View.OnTouchListener {
            private var mHandler: Handler? = null
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        if (mHandler != null) return true
                        mHandler = Handler()
                        mHandler!!.postDelayed(mAction, 100)
                    }
                    MotionEvent.ACTION_UP -> {
                        if (mHandler == null) return true
                        mHandler!!.removeCallbacks(mAction)
                        mHandler = null
                    }
                }
                return false
            }

            var mAction: Runnable = object : Runnable {
                override fun run() {
                    if (bindingClass.textView.text.toString().isNotEmpty()) {
                        var s: String = bindingClass.textView.text.toString()
                        s = s.substring(0, s.length - 1)
                        bindingClass.textView.text = s
                        tmpArr.pop()
                    }
                    mHandler!!.postDelayed(this, 100)
                }
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.changePassword -> {
                val intent = Intent(this@MainActivity, ChoicePassvord::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onClickOne(view: View) {
        tmpArr.add(1)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()

        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.one.text
        bindingClass.textView.text = s

    }

    fun onClickTwo(view: View) {
        tmpArr.add(2)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()
        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.two.text
        bindingClass.textView.text = s
    }

    fun onClickThree(view: View) {
        tmpArr.add(3)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()
        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.three.text
        bindingClass.textView.text = s
    }

    fun onClickFour(view: View) {
        tmpArr.add(4)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()
        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.four.text
        bindingClass.textView.text = s
    }

    fun onClickFive(view: View) {
        tmpArr.add(5)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()
        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.five.text
        bindingClass.textView.text = s
    }

    fun onClickSix(view: View) {
        tmpArr.add(6)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()
        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.six.text
        bindingClass.textView.text = s
    }

    fun onClickSeven(view: View) {
        tmpArr.add(7)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()
        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.seven.text
        bindingClass.textView.text = s
    }

    fun onClickIeght(view: View) {
        tmpArr.add(8)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()
        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.eight.text
        bindingClass.textView.text = s
    }

    fun onClickNine(view: View) {
        tmpArr.add(9)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()
        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.nine.text
        bindingClass.textView.text = s
    }

    fun onClickZero(view: View) {
        tmpArr.add(0)
        if (tmpArr.size >= arrSimplePass.size)
            enableNumbers_FALSE()
        var s: String = bindingClass.textView.text.toString()
        s += bindingClass.zero.text
        bindingClass.textView.text = s
    }

    fun onClickDelete(view: View) {
        if (bindingClass.textView.text.toString().isNotEmpty()) {
            var s: String = bindingClass.textView.text.toString()
            s = s.substring(0, s.length - 1)
            bindingClass.textView.text = s
            tmpArr.pop()
        }
    }

    fun onClickEnter(view: View) {
        bindingClass.textView.text = ""
        if (tmpArr == arrSimplePass){
            bindingClass.tvCorrect.visibility = View.VISIBLE
            finish()
        }
        else{
            bindingClass.tvIncorrect.visibility = View.VISIBLE
            enableNumbers_FALSE()
            val timer = object: CountDownTimer(TIME, INTERVAL) {
                override fun onTick(millisUntilFinished: Long) {}

                override fun onFinish() {
                    bindingClass.tvIncorrect.visibility = View.VISIBLE
                    enableNumbers_TRUE()
                    tmpArr.clear()
                    fillButtons()
                    bindingClass.tvIncorrect.visibility = View.GONE
                }
            }
            timer.start()
        }
    }

    private fun fillButtons(){
        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        numbers.shuffle()
        bindingClass.one.text = numbers[0].toString()
        bindingClass.two.text = numbers[1].toString()
        bindingClass.three.text = numbers[2].toString()
        bindingClass.four.text = numbers[3].toString()
        bindingClass.five.text = numbers[4].toString()
        bindingClass.six.text = numbers[5].toString()
        bindingClass.seven.text = numbers[6].toString()
        bindingClass.eight.text = numbers[7].toString()
        bindingClass.nine.text = numbers[8].toString()
        bindingClass.zero.text = numbers[9].toString()
    }


    private fun enableNumbers_TRUE(){
        bindingClass.one.isEnabled = true
        bindingClass.two.isEnabled = true
        bindingClass.three.isEnabled = true
        bindingClass.four.isEnabled = true
        bindingClass.five.isEnabled = true
        bindingClass.six.isEnabled = true
        bindingClass.seven.isEnabled = true
        bindingClass.eight.isEnabled = true
        bindingClass.nine.isEnabled = true
        bindingClass.zero.isEnabled = true
        bindingClass.delete.isEnabled = true
    }

    private fun enableNumbers_FALSE(){
        bindingClass.one.isEnabled = false
        bindingClass.two.isEnabled = false
        bindingClass.three.isEnabled = false
        bindingClass.four.isEnabled = false
        bindingClass.five.isEnabled = false
        bindingClass.six.isEnabled = false
        bindingClass.seven.isEnabled = false
        bindingClass.eight.isEnabled = false
        bindingClass.nine.isEnabled = false
        bindingClass.zero.isEnabled = false
        bindingClass.delete.isEnabled = false
    }

    companion object {
        const val TIME = 2000L
        const val INTERVAL = 100L
    }

}