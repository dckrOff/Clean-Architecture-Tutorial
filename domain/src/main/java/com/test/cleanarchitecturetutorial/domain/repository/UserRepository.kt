package com.test.cleanarchitecturetutorial.domain.repository

import com.test.cleanarchitecturetutorial.domain.model.SaveUserNameParam
import com.test.cleanarchitecturetutorial.domain.model.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}