package com.test.cleanarchitecturetutorial.data.storage

import com.test.cleanarchitecturetutorial.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}