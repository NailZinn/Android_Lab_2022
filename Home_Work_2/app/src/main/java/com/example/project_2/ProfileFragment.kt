package com.example.project_2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project_2.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)

        with (binding) {
            btToSearch.setOnClickListener {
                findNavController().navigate(
                    R.id.action_profileFragment_to_searchFragment,
                    SearchFragment.createBundle(
                        tvProfileFragment.text.toString()
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