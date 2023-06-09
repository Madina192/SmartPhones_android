package com.example.smartphones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartphones.adapter.PhoneAdapter
import com.example.smartphones.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

   private lateinit var binding: FragmentDetailBinding

    private lateinit var phone: Phone

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            phone = bundle.getParcelable("phone")!!
        }

        addElements()
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }*/

    private fun addElements() {
        binding.imageViewImage.setImageResource(phone.image)
        binding.textViewName.text = phone.name
        binding.textViewPrice.text = phone.price
    }
}
