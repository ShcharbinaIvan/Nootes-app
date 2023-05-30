package com.ntes_app.validation

sealed class ValidationResult {

    object Valid : ValidationResult()
    class Invalid(val errorId: Int) : ValidationResult()
}