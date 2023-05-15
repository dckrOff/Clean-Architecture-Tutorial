package com.test.data.cleanarchitecturetutorial.data.storage

import com.test.data.cleanarchitecturetutorial.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}