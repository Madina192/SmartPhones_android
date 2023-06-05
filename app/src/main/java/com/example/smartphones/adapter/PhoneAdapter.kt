package com.example.smartphones.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartphones.Phone
import com.example.smartphones.R
import com.example.smartphones.databinding.ItemPhoneBinding

class PhoneAdapter(private val arrayList: ArrayList<Phone>) : RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        return PhoneViewHolder(ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    inner class PhoneViewHolder(private val binding : ItemPhoneBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(phone : Phone){
            binding.imageViewImage.setImageResource(phone.image)
            binding.textViewName.text = phone.name
            binding.textViewPrice.text = phone.price
            binding.textViewOldPrice.text = phone.oldPrice

            if(phone.isFavourite){
                binding.imageViewLike.setImageResource(R.drawable.ic_like_full)
            } else {
                binding.imageViewLike.setImageResource(R.drawable.ic_like_red)
            }
        }
    }
}