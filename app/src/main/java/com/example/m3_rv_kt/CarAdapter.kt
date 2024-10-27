package com.example.m3_rv_kt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m3_rv_kt.databinding.ItemCarBinding

class CarAdapter(private val cars : ArrayList<Car> , var onClick: (position : Int) -> Unit) : RecyclerView.Adapter<CarAdapter.CarViewHolder>(){
    inner class CarViewHolder(private val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(car: Car){
            binding.apply {
                textViewCost.text = car.cost
                textViewBrand.text = car.brand
                Glide.with(imageViewCar).load(car.image).into(imageViewCar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context))
        return CarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.onBind(cars[position])
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }
}