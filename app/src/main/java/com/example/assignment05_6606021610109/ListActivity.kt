package com.example.assignment05_6606021610109

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val listView = findViewById<ListView>(R.id.listView)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val data = readFile()

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            data
        )

        listView.adapter = adapter

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun readFile(): ArrayList<String> {
        val list = ArrayList<String>()

        try {
            val file = openFileInput("cost.txt")
            val reader = BufferedReader(InputStreamReader(file))

            var line: String?
            while (reader.readLine().also { line = it } != null) {
                list.add(line!!)
            }

            reader.close()
        } catch (e: Exception) {
            list.add("ไม่มีข้อมูล")
        }

        return list
    }
}