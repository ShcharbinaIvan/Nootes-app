package com.ntes_app.database.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ntes_app.model.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserEntity)

    @Query(
        "SELECT * FROM user WHERE userFirstName=(:firstName) AND userLastName=(:lastName)"
    )
    suspend fun getUser(firstName: String, lastName: String): List<UserEntity>

    @Delete
    suspend fun deleteUser(user: UserEntity)

}