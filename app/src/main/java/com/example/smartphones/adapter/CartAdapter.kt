package com.example.smartphones.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.smartphones.HomeFragment
import com.example.smartphones.Phone
import com.example.smartphones.databinding.ItemPhoneInCartBinding

class CartAdapter() : Adapter<CartAdapter.CartViewHolder>() {

    private val list = arrayListOf<Phone>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            ItemPhoneInCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CartViewHolder(private val binding: ItemPhoneInCartBinding) :
        ViewHolder(binding.root) {
        fun onBind(phone: Phone) {
            if (phone.isInCart) {
                binding.textViewName.text = phone.name
                binding.imageViewImage.setImageResource(phone.image)
                binding.tvPrice.text = phone.price
            }
        }
    }

}