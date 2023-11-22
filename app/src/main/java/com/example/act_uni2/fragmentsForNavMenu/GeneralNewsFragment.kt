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
import com.example.act_uni2.databinding.FragmentGeneralNewsBinding
import com.example.act_uni2.recyclerView.NewRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.example.misnoticias.data.New
import com.example.misnoticias.data.getTech
import getAllNews


class GeneralNewsFragment : Fragment() {

    private lateinit var _binding: FragmentGeneralNewsBinding
    private val binding: FragmentGeneralNewsBinding get() = _binding

    private lateinit var fabAddNews: ExtendedFloatingActionButton

    private lateinit var adapter: NewRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGeneralNewsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvGeneralNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        fabAddNews = binding.fabAddNews
        val list = getAllNews()
        loadRecyclerView(list)
        listenFabAddNews()

    }


    private fun listenFabAddNews() {
        fabAddNews.setOnClickListener {
            val list = getAllNews() + getSport() + getTech()
            loadRecyclerView(list)
        }
    }

    private fun loadRecyclerView(list: List<New>) {
        adapter = NewRecyclerViewAdapter(list) { id -> navigateToDetaill(id) }
        binding.rvGeneralNews.adapter = adapter
    }

    private fun navigateToDetaill(id: String) {
        val intent = Intent(requireContext(), DetaillNewsActivity::class.java)
        intent.putExtra("title", id)
        startActivity(intent)
    }


}
