package com.example.mytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytestapp.databinding.ActivityMainBinding
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //code to save bopa to database
        binding.saveBopaEntry.setOnClickListener {
            val db = DBHelper(this,null)
            val topic = binding.bopaTopic.text.toString()
            val bopa = binding.bopaContent.text.toString()
            db.addBOPA(topic,bopa)
            Toast.makeText(this, topic + " saved", Toast.LENGTH_LONG).show()
            binding.bopaTopic.text.clear()
            binding.bopaContent.text.clear()
        }

        //code to open previous entries from database
        binding.openBopaEntry.setOnClickListener {
            val db = DBHelper(this, null)
            val cursor = db.getName()
            cursor!!.moveToFirst()
            binding.bopaTopic.append(cursor.getString(cursor.getColumnIndex(DBHelper.TOPIC_COl)) + "\n")
            binding.bopaContent.append(cursor.getString(cursor.getColumnIndex(DBHelper.BOPA_COL)) + "\n")
            while (cursor.moveToNext()) {
                binding.bopaTopic.append(cursor.getString(cursor.getColumnIndex(DBHelper.TOPIC_COl)) + "\n")
                binding.bopaContent.append(cursor.getString(cursor.getColumnIndex(DBHelper.BOPA_COL)) + "\n")
            }
            cursor.close()
        }
    }
}