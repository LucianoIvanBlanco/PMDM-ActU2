package com.example.act_uni2.fragmentsForNavMenu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.act_uni2.DetaillNewsActivity
import com.example.act_uni2.data.getSport
import com.example.act_uni2.databinding.FragmentSportsNewsBinding
import com.example.act_uni2.recyclerView.NewRecyclerViewAdapter


class SportsNewsFragment : Fragment() {

    private lateinit var _binding: FragmentSportsNewsBinding
    private val binding: FragmentSportsNewsBinding get() = _binding

    private lateinit var adapter: NewRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSportsNewsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSportsNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val list = getSport()
        adapter = NewRecyclerViewAdapter(list) { id -> navigateToDetail(id) }
        binding.rvSportsNews.adapter = adapter
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(requireContext(), DetaillNewsActivity::class.java)
        intent.putExtra("title", id)
        startActivity(intent)
    }
}