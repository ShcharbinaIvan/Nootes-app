package com.ntes_app.ui.validation

sealed class ValidationResult {

    object Valid : ValidationResult()
    class Invalid(val errorId: Int) : ValidationResult()
}