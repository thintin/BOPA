package com.example.mytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytestapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
        }

        // below code is to add on click listener to our add name button addName.setOnClickListener{
        binding.saveBopaEntry.setOnClickListener{


            // below we have created a new DBHelper class,and passed context to it
            val db = DBHelper(this, null)

            // creating variables for values in name and age edit texts val name = enterName.text.toString() val age = enterAge.text.toString()
            val topic = binding.bopaTopic.text.toString()
            val bopa = binding.bopaContent.text.toString()

            // calling method to add name to our database db.addName(name, age)
            db.addBOPA(topic, bopa)

            // Toast to message on the screen
            Toast.makeText(this, topic + " saved", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts enterName.text.clear() enterAge.text.clear()
            binding.bopaTopic.text.clear()
            binding.bopaContent.text.clear()
        }

        // below code is to add on  click listener to our print name button
        //printName.setOnClickListener{

            // creating a DBHelper class and passing context to it
            //val db = DBHelper(this, null)

            // below is the variable for cursor we have called method to get all names from our database and add to name text view
            //val cursor = db.getName()

            // moving the cursor to first position and appending value in the text view
            //cursor!!.moveToFirst()
            //Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
           // Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")

            // moving our cursor to next position and appending values
           // while(cursor.moveToNext()){
               // Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
               // Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
           // }

            // at last we close our cursor
            //cursor.close()

    }