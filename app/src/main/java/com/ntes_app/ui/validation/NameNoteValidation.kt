package com.ntes_app.ui.validation

import com.ntes_app.R


fun nameNoteValidation(name: String): ValidationResult {
    return when {
        name.length == 0 -> ValidationResult.Invalid(R.string.name_empty)
        else -> ValidationResult.Valid
    }
}