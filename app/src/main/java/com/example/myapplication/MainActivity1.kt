package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val btn_main_collection:Button=findViewById(R.id.btn_main_collection)
        val btn_main_quizgo:Button=findViewById(R.id.btn_main_goquiz)

        btn_main_quizgo.setOnClickListener(){
            startActivity(Intent(this,QuizActivity::class.java))
        }
        btn_main_collection.setOnClickListener(){
            startActivity(Intent(this,CollectionActivity::class.java))
        }
    }

}