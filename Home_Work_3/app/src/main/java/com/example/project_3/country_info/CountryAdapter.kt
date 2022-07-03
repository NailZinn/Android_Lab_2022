package com.example.project_3.country_info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_3.databinding.ItemCountryBinding

class CountryAdapter(
    private val list: List<Country>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<CountryHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryHolder = CountryHolder(
        ItemCountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onItemClick
    )

    override fun onBindViewHolder(
        holder: CountryHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}