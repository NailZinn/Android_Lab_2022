package com.example.project_3.country_info

import androidx.recyclerview.widget.RecyclerView
import com.example.project_3.databinding.ItemCountryBinding


class CountryHolder(
    private val binding: ItemCountryBinding,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(country: Country) {
        with(binding) {
            tvName.text = country.name
            tvCapital.text = country.capital
            ivFlag.setImageResource(country.flag)
            root.setOnClickListener {
                onItemClick(country.id)
            }
        }
    }
}