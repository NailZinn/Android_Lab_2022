package com.example.project_2

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.project_2.databinding.FragmentSearchBinding
import com.google.android.material.snackbar.Snackbar

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)

        val text = arguments?.getString(KEY).orEmpty()

        if (text.isNotEmpty())
            Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show()
    }

    companion object {

        private const val KEY = "fragment_search"

        fun createBundle(text: String): Bundle {
            return bundleOf(KEY to text)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}