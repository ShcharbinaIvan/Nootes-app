package com.ntes_app.repositories

import com.ntes_app.database.AppNotesDataBase
import com.ntes_app.model.Note
import com.ntes_app.model.User
import com.ntes_app.model.entity.UserEntity

class UserRepository {

    suspend fun addUser(user: User) {
        AppNotesDataBase.userDao?.addUser(
            UserEntity(
                0,
                user.userFirstName,
                user.userLastName,
                user.userEmail,
                user.userPassword
            )
        )
    }

    suspend fun getAllUsers(): ArrayList<User> {
        return (AppNotesDataBase.userDao?.getAllUsers()?.map {
            User(
                it.userFirstName,
                it.userLastName,
                it.userEmail,
                it.userPassword
            )
        } as ArrayList<User>) ?: arrayListOf()
    }

    suspend fun deleteUser(user: User) = AppNotesDataBase.listUser.remove(user)

}