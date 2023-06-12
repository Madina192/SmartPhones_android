package com.example.smartphones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.smartphones.adapter.PhoneAdapter
import com.example.smartphones.databinding.FragmentHomeBinding
import java.util.Locale

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private var arrayList : ArrayList<Phone> = ArrayList()
    lateinit var adapter : PhoneAdapter
    private lateinit var searchView : SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addElements()
        adapter = PhoneAdapter(arrayList) {
            val bundle  = Bundle()
            val detailFragment = DetailFragment()
            bundle.putParcelable("phone", it)
            detailFragment.arguments = bundle
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle )
        }

        val recyclerView = binding.recyclerViewBestSellers
        recyclerView.adapter = adapter

        searchByName()
    }

    private fun addElements(){
        arrayList.add(Phone(R.drawable.img_samsung_galaxy, "Samsung Galaxy s20 Ultra", "$1,047", "$1,500", false, false, false))
        arrayList.add(Phone(R.drawable.img_xiaomi, "Xiaomi Mi 10 Pro", "$300", "$400", false, false, false))
        arrayList.add(Phone(R.drawable.img_samsung_note, "Samsung Note 20 Ultra", "$1, 047", "$1, 500", false, false, false))
        arrayList.add(Phone(R.drawable.img_motorola, "Motorola One Edge ", "$300", "$400", false, false, false))
    }

    private fun searchByName() {
        searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(query: String?) {
        if (query != null){
            val filteredList = ArrayList<Phone>()
            for(i in arrayList){
                if(i.name.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if(filteredList.isEmpty()){
                Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }


}
