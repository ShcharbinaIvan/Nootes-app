package com.ntes_app.database

import android.content.Context
import androidx.room.Room
import com.ntes_app.database.note.NotesDao
import com.ntes_app.database.user.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppNotesModule {

    @Provides
    @Singleton
    fun provideNotes(@ApplicationContext context: Context): NotesDao {
        return Room.databaseBuilder(context, NotesDateBase::class.java, "data-base").build().getNotesDao()
    }

    @Provides
    @Singleton
    fun provideUser(@ApplicationContext context: Context): UserDao {
        return Room.databaseBuilder(context, NotesDateBase::class.java, "data-base").build().getUserDao()
    }

}