package com.test.cleanarchitecturetutorial.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.test.cleanarchitecturetutorial.R
import com.test.cleanarchitecturetutorial.domain.model.SaveUserNameParam
import com.test.cleanarchitecturetutorial.domain.usecase.GetUserNameUseCase
import com.test.cleanarchitecturetutorial.domain.usecase.SaveUserNameUseCase
import com.test.data.cleanarchitecturetutorial.data.repository.UserRepositoryImpl
import com.test.data.cleanarchitecturetutorial.data.storage.sharedprefs.SharedPrefsUserStorage

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context = applicationContext))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvText: TextView = findViewById(R.id.tv_text)
        val etInput: EditText = findViewById(R.id.et_data)
        val btnGetData: Button = findViewById(R.id.btn_get_data)
        val btnSaveData: Button = findViewById(R.id.btn_save_data)

        btnSaveData.setOnClickListener {
            val userNameParam = SaveUserNameParam(name = etInput.text.toString())
            tvText.text = "Save data result: ${saveUserNameUseCase.execute(param = userNameParam)}"
        }

        btnGetData.setOnClickListener {
            tvText.text = getUserNameUseCase.execute().firstName
        }
    }
}