package com.example.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.content.res.Resources
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    lateinit var correctAns:TextView
    lateinit var totalAns:TextView
    lateinit var performance:TextView
    lateinit var output:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        supportActionBar?.hide()

        correctAns=findViewById(R.id.correctAns)
        totalAns=findViewById(R.id.totalAns)
        performance=findViewById(R.id.performance)
        output=findViewById(R.id.output)

        val intent = intent
        val correctAnsNo=intent.getStringExtra("correct")
        val totalAnsNo=intent.getStringExtra("total")
        correctAns.text=correctAnsNo
        totalAns.text=totalAnsNo

        val percentage= (correctAnsNo?.toFloat()?.div(totalAnsNo?.toFloat()!!))?.times(100)

        if (percentage != null) {
            when {
                50 <= percentage && percentage <= 99 -> {

                    performance.text="GOOD"
                    output.background=resources.getDrawable(R.drawable.option_bg)


                }
                percentage>=100 -> {
                    performance.text="EXCELLENT"
                    output.background=resources.getDrawable(R.drawable.right_bg)
                }
                percentage<50 -> {
                    performance.text="POOR"
                    output.background=resources.getDrawable(R.drawable.wrong_bg)
                }
            }


        }
    }

    override fun onBackPressed() {
        var intent= Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }
}