package com.example.owner.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_plus.setOnClickListener(this)
        button_minus.setOnClickListener(this)
        button_multiple.setOnClickListener(this)
        button_divide.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, SecondActivity::class.java)
        var result = 0.0
        var intentFlg = true

        try {
            if (v.id == R.id.button_plus) {
                //足し算
                result = editText1.text.toString().toDouble() + editText2.text.toString().toDouble()
            } else if (v.id == R.id.button_minus) {
                //引き算
                result = editText1.text.toString().toDouble() - editText2.text.toString().toDouble()
            } else if (v.id == R.id.button_multiple) {
                //掛け算
                result = editText1.text.toString().toDouble() * editText2.text.toString().toDouble()
            } else if (v.id == R.id.button_divide) {
                //割り算
                if(editText1.text.toString().toDouble() == 0.0 ||editText2.text.toString().toDouble() == 0.0){
                    textView1.text = "0以外の値を設定してください"
                    intentFlg = false;
                }else {
                    result = editText1.text.toString().toDouble() / editText2.text.toString().toDouble()
                }
            }
        }catch (e:NumberFormatException){
            result = 0.0;
        }
        if(intentFlg) {
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }
    }
}
