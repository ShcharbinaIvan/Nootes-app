package com.ntes_app.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ntes_app.model.Note
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ntes_app.databinding.FragmentSearchBinding
import com.ntes_app.search.adapter.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.notesListByMessage.observe(viewLifecycleOwner) {
            setListSearch(it)
        }
//        viewModel.getNoteByMessage()
        binding.searchButton.setOnClickListener {
            viewModel.getNoteMessage(binding.search.text.toString())
        }


    }

    private fun setListSearch(listSearch: ArrayList<Note>) {
        binding.searchRecyclerView.run {
            if (adapter == null) {
                adapter = SearchAdapter()
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? SearchAdapter)?.submitList(listSearch)
            adapter?.notifyDataSetChanged()
        }
    }

    companion object {
        const val TAG = "SearchFragment"
    }
}