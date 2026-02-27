package com.example.assignment05_6606021610109

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.etName)
        val price = findViewById<EditText>(R.id.etPrice)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnShow = findViewById<Button>(R.id.btnShow)

        btnSave.setOnClickListener {

            val item = name.text.toString()
            val money = price.text.toString()

            if (item.isEmpty() || money.isEmpty()) {
                Toast.makeText(this, "กรอกข้อมูลก่อน", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            saveToFile("$item : $money\n")

            name.text.clear()
            price.text.clear()

            Toast.makeText(this, "บันทึกแล้ว", Toast.LENGTH_SHORT).show()
        }

        btnShow.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
    }

    private fun saveToFile(data: String) {
        val file = openFileOutput("cost.txt", MODE_APPEND)
        val writer = OutputStreamWriter(file)
        writer.append(data)
        writer.close()
    }
}