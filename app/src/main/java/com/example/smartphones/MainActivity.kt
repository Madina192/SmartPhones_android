package com.example.smartphones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartphones.adapter.PhoneAdapter
import com.example.smartphones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var arrayList : ArrayList<Phone> = ArrayList()
    lateinit var adapter : PhoneAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addElements()
        adapter = PhoneAdapter(arrayList)
        binding.recyclerViewBestSellers.adapter = adapter

    }

    private fun addElements(){
        arrayList.add(Phone(R.drawable.img_samsung_galaxy, "Samsung Galaxy s20 Ultra", "$1,047", "$1,500", false, false))
        arrayList.add(Phone(R.drawable.img_xiaomi, "Xiaomi Mi 10 Pro", "$300", "$400", false, false))
        arrayList.add(Phone(R.drawable.img_samsung_note, "Samsung Note 20 Ultra", "$1, 047", "$1, 500", false, false))
        arrayList.add(Phone(R.drawable.img_motorola, "Motorola One Edge ", "$300", "$400", false, false))
    }
}