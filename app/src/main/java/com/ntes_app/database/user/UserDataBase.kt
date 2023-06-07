package com.ntes_app.database.user

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ntes_app.model.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDataBase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

}