package com.example.project_3.country_info

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.project_3.R
import com.example.project_3.databinding.FragmentCountryInfoBinding

class CountryInfoFragment : Fragment(R.layout.fragment_country_info) {

    private var _binding: FragmentCountryInfoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCountryInfoBinding.bind(view)

        val countryInfo = arguments?.getInt(KEY).let {
            val country = CountryRepository.countries[it!!]
            "Id: ${country.id} \n" +
            "Name: ${country.name} \n" +
            "Capital: ${country.capital} \n" +
            "More info: ${Uri.parse(country.uri)}"
        }

        with (binding) {
            tvCountryInfo.text = countryInfo
        }
    }

    companion object {

        private const val KEY = "info"

        fun createBundle(id: Int) = bundleOf(KEY to id)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}