package com.example.mytestapp

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //button actions
        binding.saveBopaEntry.setOnClickListener{
            //code for sending editText to db
            BopaRoomDao.updateBopa(bopaTopic = R.id.bopaTopic, bopaContent = R.id.bopaContent)
        }

        binding.openBopaEntry.setOnClickListener{
            //code for opening previous lists from db
        }

        binding.instructionsButton.setOnClickListener{
            //code for opening instructions page
        }
    }
}

class MainViewModelFactory(val application: Application) :
        ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainViewModel(application) as T
            }
        }
