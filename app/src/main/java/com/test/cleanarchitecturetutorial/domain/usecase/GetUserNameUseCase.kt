package com.test.cleanarchitecturetutorial.domain.usecase

import com.test.cleanarchitecturetutorial.domain.model.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Azamat", lastName = "Otaboev")
    }
}
