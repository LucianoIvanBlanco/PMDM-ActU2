package com.example.act_uni2.fragmentsForNavMenu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.act_uni2.DetaillNewsActivity
import com.example.act_uni2.databinding.FragmentTechNewsBinding
import com.example.act_uni2.recyclerView.NewRecyclerViewAdapter
import com.utad.misnoticias.data.getTech

class TechNewsFragment : Fragment() {

    private lateinit var _binding: FragmentTechNewsBinding
    private val binding: FragmentTechNewsBinding get() = _binding

    private lateinit var adapter : NewRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTechNewsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTechNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        val list = getTech()
        adapter = NewRecyclerViewAdapter(list){id -> navigateToDetail(id)}
        binding.rvTechNews.adapter = adapter

    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(requireContext(), DetaillNewsActivity::class.java)
        intent.putExtra("title", id)
        startActivity(intent)
    }
}