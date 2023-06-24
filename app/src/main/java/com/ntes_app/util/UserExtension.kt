package com.ntes_app.util

import com.ntes_app.model.User
import com.ntes_app.model.entity.UserEntity

fun getUserEntity(userEntity: UserEntity): User {
    return User(
        userEntity.userFirstName,
        userEntity.userLastName,
        userEntity.userEmail,
        userEntity.userPassword
    )
}