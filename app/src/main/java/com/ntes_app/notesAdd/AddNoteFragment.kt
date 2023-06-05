package com.ntes_app.notesAdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ntes_app.R
import com.ntes_app.databinding.FragmentAddNoteBinding
import com.ntes_app.model.Note
import com.ntes_app.util.getString
import com.ntes_app.validation.ValidationResult
import com.ntes_app.validation.nameNoteValidation
import java.util.Date

class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNoteBinding
    private val viewModel: AddNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            if (validate()) {
                addNote()
                Toast.makeText(requireContext(), R.string.note_saved, Toast.LENGTH_LONG).show()
                parentFragmentManager.popBackStack()
            }
        }
    }

    private fun validate(): Boolean {
        val nameValidationResult = nameNoteValidation(binding.titleEditText.getString())
        when (nameValidationResult) {
            is ValidationResult.Invalid -> binding.titleEditText.error =
                requireContext().getString(nameValidationResult.errorId)

            else -> binding.titleEditText.error = null
        }
        return nameValidationResult == ValidationResult.Valid
    }

    private fun addNote() {
        val note = Note(
            binding.titleEditText.getString(),
            Date().time,
            binding.messageEditText.getString()
        )
        viewModel.addNewNote(note)


    }

    companion object {
        const val TAG = "AddNoteFragment"
    }
}