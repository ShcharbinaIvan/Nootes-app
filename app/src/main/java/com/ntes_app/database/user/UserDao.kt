package com.ntes_app.database.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ntes_app.model.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: UserEntity)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<UserEntity>

}