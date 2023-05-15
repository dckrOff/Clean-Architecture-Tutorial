package com.test.cleanarchitecturetutorial.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.test.cleanarchitecturetutorial.R

class MainActivity : AppCompatActivity() {


    private lateinit var vm: MainViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("TAG", "Activity created")
        vm = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        val tvText: TextView = findViewById(R.id.tv_text)
        val etInput: EditText = findViewById(R.id.et_data)
        val btnGetData: Button = findViewById(R.id.btn_get_data)
        val btnSaveData: Button = findViewById(R.id.btn_save_data)

        vm.resultLive.observe(this) {
            tvText.text = it
        }

        btnSaveData.setOnClickListener {
            vm.save(etInput.text.toString())
        }

        btnGetData.setOnClickListener {
            vm.load()
        }
    }
}