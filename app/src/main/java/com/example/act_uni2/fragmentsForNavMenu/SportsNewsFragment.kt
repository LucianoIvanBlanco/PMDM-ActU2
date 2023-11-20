package com.example.act_uni2.fragmentsForNavMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.act_uni2.R
import com.example.act_uni2.databinding.FragmentGeneralNewsBinding
import com.example.act_uni2.databinding.FragmentSportsNewsBinding


class SportsNewsFragment : Fragment() {

    private lateinit var _binding: FragmentSportsNewsBinding
    private val binding: FragmentSportsNewsBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSportsNewsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}