package com.test.cleanarchitecturetutorial.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.cleanarchitecturetutorial.domain.usecase.GetUserNameUseCase
import com.test.cleanarchitecturetutorial.domain.usecase.SaveUserNameUseCase
import com.test.data.cleanarchitecturetutorial.data.repository.UserRepositoryImpl
import com.test.data.cleanarchitecturetutorial.data.storage.sharedprefs.SharedPrefsUserStorage

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context = context))
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

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}