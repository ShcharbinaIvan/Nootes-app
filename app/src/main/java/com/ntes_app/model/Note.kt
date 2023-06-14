package com.ntes_app.model


data class Note(
    val id: Int,
    val email: String,
    val name: String,
    val date: Long,
    val message: String
)