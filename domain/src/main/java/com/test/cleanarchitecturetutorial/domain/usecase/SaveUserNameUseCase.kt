package com.test.cleanarchitecturetutorial.domain.usecase

import com.test.cleanarchitecturetutorial.domain.model.SaveUserNameParam
import com.test.cleanarchitecturetutorial.domain.repository.UserRepository


class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        return userRepository.saveName(saveParam = param)
    }

}