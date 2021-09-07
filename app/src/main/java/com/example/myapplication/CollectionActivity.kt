package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class CollectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)
        var mutablelist= mutableListOf<String>("LIST1", "LIST2", "LIST3")


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutablelist)
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, answerList)
        val listview = findViewById(R.id.list_collect_list) as ListView
        listview.setAdapter(adapter)

        listview.setOnItemClickListener {parent, view, position, id ->
            val intent=Intent(this,boksupActivity::class.java)
            //intent.put("questType",questionList[position])
            startActivity(intent)
        }

    }
}