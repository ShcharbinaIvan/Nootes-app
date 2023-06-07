package com.ntes_app.validation

import com.ntes_app.R


fun nameNoteValidation(name: String): ValidationResult {
    return when {
        name.length == 0 -> ValidationResult.Invalid(R.string.name_empty)
        else -> ValidationResult.Valid
    }
}

fun userFirstNameValidation(firstName: String): ValidationResult {
    return when {
        firstName.length == 0 -> ValidationResult.Invalid(R.string.insert_first_name)
        else -> ValidationResult.Valid
    }

}
