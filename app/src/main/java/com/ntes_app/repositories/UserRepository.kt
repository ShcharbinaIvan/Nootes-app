package com.ntes_app.repositories

import com.ntes_app.database.user.UserDao
import com.ntes_app.model.User
import com.ntes_app.model.entity.UserEntity
import com.ntes_app.util.getUserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun addUser(user: User) {
        userDao.addUser(
            UserEntity(
                user.userFirstName,
                user.userLastName,
                user.userEmail,
                user.userPassword
            )
        )
    }

    suspend fun getUser(email: String): User? {
        val userEntity = userDao.getUser(email)
        return if (userEntity != null) {
            getUserEntity(userEntity)
        } else {
            null
        }
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(
            UserEntity(
                user.userFirstName,
                user.userLastName,
                user.userEmail,
                user.userEmail
            )
        )
    }

}