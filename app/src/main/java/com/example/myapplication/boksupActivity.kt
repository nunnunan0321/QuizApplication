package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class boksupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.boksup)
        var question=intent.getStringArrayListExtra("questionList")
        var answer=intent.getStringArrayListExtra("answerList")
        val txt_bok_watchAnswer:TextView=findViewById(R.id.txt_bok_watchAnswer)
        val txt_bok_quest:TextView=findViewById(R.id.txt_bok_quest)
        val txt_bok_answer:TextView=findViewById(R.id.txt_bok_answer)

//        txt_bok_quest.text=
    }
}