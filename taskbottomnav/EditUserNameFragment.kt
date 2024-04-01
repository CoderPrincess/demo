package com.example.taskbottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.taskbottomnav.databinding.FragmentEditUserNameBinding

class EditUserNameFragment : Fragment(R.layout.fragment_edit_user_name) {

    private val viewModel: EditUserNameViewModel by viewModels {
        EditUserNameViewModelFactory(
            requireActivity().application,
            UserRepository(
                AppDataBase.getDataBase(requireContext().applicationContext).userDao()
            )
        )
    }

    private lateinit var binding: FragmentEditUserNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentEditUserNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (validateInputs(username, password)) {
                viewModel.updateUser(username, password)

                Toast.makeText(requireContext(), "Username and Password Successfully updated", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(username: String, password: String): Boolean {
        if (username.isEmpty()){
            binding.etUsername.error = "Please enter a username"
            return false
        }
        if (password.isEmpty()){
            binding.etUsername.error = "Please enter a password"
            return false
        }
        return true
    }
}