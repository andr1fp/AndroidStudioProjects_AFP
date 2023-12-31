package com.bootcamp.apirickandmoney.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.apirickandmoney.R
import com.bootcamp.apirickandmoney.ResponseMorty
import com.bootcamp.apirickandmoney.ResultsItem
import com.bootcamp.apirickandmoney.databinding.ItemRowMortyBinding
import com.bumptech.glide.Glide

class MortyAdapter() : RecyclerView.Adapter<MortyAdapter.MyViewHolder>() {

    private var dataMorty: List<ResultsItem> = listOf()

    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemRowMortyBinding.bind(view)

        fun bind(morty: ResultsItem){
            binding.apply {
                itemNameMorty.text = morty.name
                itemStatusMorty.text = morty.status
                itemSpeciesMorty.text = morty.species

                Glide.with(itemImageMorty)
                    .load(morty.image)
                    .error(R.drawable.ic_launcher_background)
                    .into(itemImageMorty)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_morty, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataMorty.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataMorty[position])
    }

    fun setData(data: List<ResultsItem>){
        dataMorty = data
        notifyDataSetChanged()
    }

}