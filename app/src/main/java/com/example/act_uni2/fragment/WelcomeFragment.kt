package com.example.act_uni2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.example.act_uni2.R
import com.example.act_uni2.databinding.FragmentWelcomeBinding
import com.google.android.material.snackbar.Snackbar


class WelcomeFragment : Fragment() {

    private lateinit var _binding: FragmentWelcomeBinding
    private val binding: FragmentWelcomeBinding get() = _binding
    private var value = false
    private var valorCb = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

        // Metodo donde metemos la logica del fragmento
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            // Control de seleccion de checkbox
            binding.cb1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    binding.cb2.isChecked = false
                    binding.cb3.isChecked = false
                    value = true
                    valorCb = binding.cb1.text.toString()
                }
            }
            binding.cb2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    binding.cb1.isChecked = false
                    binding.cb3.isChecked = false
                    value = true
                    valorCb = binding.cb2.text.toString()
                }
            }
            binding.cb3.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    binding.cb1.isChecked = false
                    binding.cb2.isChecked = false
                    value = true
                    valorCb = binding.cb3.text.toString()
                }
            }

            // Evento del boton para ir al siguiente fragmento
            binding.btnLogin.setOnClickListener {
                val nameValue = binding.etName.text.toString().trim()
                if (validator()) {
                    navigateTermFragment(nameValue, valorCb)
                } else{
                    showEmptyFieldsMessage()
                }
            }

    }

        // Validamos que esten rellenos los campos y el check
    private fun validator(): Boolean {
        val userName = binding.etName.text.toString().trim()

        if (userName.isNullOrEmpty()) {
            return false
        }
        if (!value) {
            return false
        }
        return true
    }

        // Muestra mensaje de error
    private fun showEmptyFieldsMessage() {
        val message = getString(R.string.login_empty_fields_error_message)
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }


        // Navegamos al siguiente fragmento
        private fun navigateTermFragment(nameValue: String, valorCb: String) {
            val bundle = Bundle()
            bundle.putString("name", nameValue)
            bundle.putString("valorCb", valorCb)

        val termFragment = TermFragment()
            termFragment.arguments = bundle

        val transaction = parentFragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            transaction.replace(R.id.fcv_nav_graph, termFragment)
            transaction.addToBackStack(null)                    // Para que al pulsar atras se pueda volver
            transaction.setTransition(TRANSIT_FRAGMENT_OPEN)
        transaction.commit()
    }

}