package com.test.cleanarchitecturetutorial.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.cleanarchitecturetutorial.domain.model.SaveUserNameParam
import com.test.cleanarchitecturetutorial.domain.usecase.GetUserNameUseCase
import com.test.cleanarchitecturetutorial.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val resultMutableLiveData = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultMutableLiveData

    init {
        Log.e("TAG", "VM created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("TAG", "VM cleared")
    }

    fun save(text: String) {
        val userNameParam = SaveUserNameParam(name = text)
        resultMutableLiveData.value =
            "Save data result: ${saveUserNameUseCase.execute(param = userNameParam)}"
    }

    fun load() {
        resultMutableLiveData.value = getUserNameUseCase.execute().firstName
    }
}