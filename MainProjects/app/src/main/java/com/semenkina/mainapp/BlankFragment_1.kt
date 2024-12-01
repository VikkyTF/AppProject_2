package com.semenkina.mainapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment_1.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment_1 : Fragment() {
    private val myAdapter = PhonesAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_blank_1,container,false)
        loadData()
        val rv: RecyclerView = root.findViewById(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = myAdapter
        return root
    }
    private fun loadData(){
        myAdapter.setupPhones(PhonesData.phonesArr)
    }
}