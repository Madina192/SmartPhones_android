package com.example.smartphones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartphones.adapter.PhoneAdapter

class HomeFragment : Fragment() {

    private var arrayList : ArrayList<Phone> = ArrayList()
    lateinit var adapter : PhoneAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addElements()
        adapter = PhoneAdapter(arrayList)
        val recyclerView = requireActivity().findViewById<RecyclerView>(R.id.recyclerViewBestSellers)
        recyclerView.adapter = adapter
    }

    private fun addElements(){
        arrayList.add(Phone(R.drawable.img_samsung_galaxy, "Samsung Galaxy s20 Ultra", "$1,047", "$1,500", false, false))
        arrayList.add(Phone(R.drawable.img_xiaomi, "Xiaomi Mi 10 Pro", "$300", "$400", false, false))
        arrayList.add(Phone(R.drawable.img_samsung_note, "Samsung Note 20 Ultra", "$1, 047", "$1, 500", false, false))
        arrayList.add(Phone(R.drawable.img_motorola, "Motorola One Edge ", "$300", "$400", false, false))
    }
}