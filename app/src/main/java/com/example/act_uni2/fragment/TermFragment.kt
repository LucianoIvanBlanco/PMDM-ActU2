package com.example.act_uni2.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.act_uni2.HomeActivity
import com.example.act_uni2.databinding.FragmentTermBinding


class TermFragment : Fragment() {

    private lateinit var _binding: FragmentTermBinding
    private val binding: FragmentTermBinding get() = _binding

    // Guardaremos los datos recibidos del fragmento
    private var name: String? = null
    private var valorCb: String? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTermBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Extrer argumentos del bundle
        if (requireArguments().containsKey("name")) {
            name = requireArguments().getString("name")
        }
        if (requireArguments().containsKey("valorCb")) {
            valorCb = requireArguments().getString("valorCb")

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.switch1.isChecked = false
        binding.btnNext.isEnabled = false

        // Aqui estamos imprimiendo los datos del fragment anterior
        binding.tvResult.setText(name + valorCb)

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.btnNext.isEnabled = isChecked
        }

        // Evento del boton para ir al siguiente fragmento
        binding.btnNext.setOnClickListener {
            navigateToNextActivity(name, valorCb)


        }

    }

    private fun navigateToNextActivity(nameValue: String?, categoryValue: String?){
        val intent = Intent(requireContext(), HomeActivity::class.java)
        intent.putExtra("nameValue", nameValue)
        intent.putExtra("categoryValue", categoryValue)
        Log.d("CategoryTag", "El valor es : $categoryValue")
        startActivity(intent)
    }

}