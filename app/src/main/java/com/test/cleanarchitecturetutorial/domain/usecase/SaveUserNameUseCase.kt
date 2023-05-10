package com.test.cleanarchitecturetutorial.domain.usecase

import com.test.cleanarchitecturetutorial.domain.model.SaveUserNameParam


class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }

}