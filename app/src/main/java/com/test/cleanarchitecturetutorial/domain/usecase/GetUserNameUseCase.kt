package com.test.cleanarchitecturetutorial.domain.usecase

import com.test.cleanarchitecturetutorial.domain.model.UserName
import com.test.cleanarchitecturetutorial.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}
