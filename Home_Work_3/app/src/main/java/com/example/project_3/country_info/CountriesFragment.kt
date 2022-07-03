package com.example.project_3.country_info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project_3.R
import com.example.project_3.databinding.FragmentCountriesBinding
import com.google.android.material.snackbar.Snackbar

class CountriesFragment : Fragment(R.layout.fragment_countries) {

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    private var adapter: CountryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentCountriesBinding.bind(view)

        adapter = CountryAdapter(CountryRepository.countries) {
            findNavController().navigate(
                R.id.action_countriesFragment_to_countryInfoFragment,
                CountryInfoFragment.createBundle(it)
            )
        }

        binding.rvCountries.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}