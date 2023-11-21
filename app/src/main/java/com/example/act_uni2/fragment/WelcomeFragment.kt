package com.example.act_uni2.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.cb1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    binding.cb2.isChecked = false
                    binding.cb3.isChecked = false
                    value = true
                    valorCb = "1"
                }
            }
            binding.cb2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    binding.cb1.isChecked = false
                    binding.cb3.isChecked = false
                    value = true
                    valorCb = "2"
                }
            }
            binding.cb3.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    binding.cb1.isChecked = false
                    binding.cb2.isChecked = false
                    value = true
                    valorCb = "3"
                }
            }

            binding.btnLogin.setOnClickListener {
                val nameValue = binding.etName.text.toString().trim()
                hideKeyBoard()
                if (validator()) {
                    navigateTermFragment(nameValue, valorCb)
                } else{
                    showEmptyFieldsMessage()
                }
            }

    }

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

    private fun showEmptyFieldsMessage() {
        val message = getString(R.string.login_empty_fields_error_message)
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

        private fun navigateTermFragment(nameValue: String, valorCb: String) {
            val bundle = Bundle()
            bundle.putString("name", nameValue)
            bundle.putString("valorCb", valorCb)

        val termFragment = TermFragment()
            termFragment.arguments = bundle

        val transaction = parentFragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            transaction.replace(R.id.fcv_nav_graph, termFragment)
            transaction.addToBackStack(null)
            transaction.setTransition(TRANSIT_FRAGMENT_OPEN)
        transaction.commit()
    }

    // Para ocultar el teclado
    private fun hideKeyBoard() {
        val imm =
            requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = requireActivity().currentFocus

        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}