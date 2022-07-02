package com.example.project_2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project_2.databinding.FragmentPicturesBinding

class PicturesFragment : Fragment(R.layout.fragment_pictures) {

    private var _binding: FragmentPicturesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPicturesBinding.bind(view)

        with (binding) {
            btToSearch.setOnClickListener {
                findNavController().navigate(
                    R.id.action_picturesFragment_to_searchFragment,
                    SearchFragment.createBundle(
                        tvPicturesFragment.text.toString()
                    )
                )
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}