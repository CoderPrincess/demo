package com.example.taskbottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.taskbottomnav.databinding.FragmentCreateUserNameBinding

class CreateUserNameFragment : Fragment(R.layout.fragment_create_user_name) {

    private lateinit var binding: FragmentCreateUserNameBinding

    private val viewModel: CreateUserNameViewModel by viewModels {
        CreateUserNameViewModelFactory(
            requireActivity().application,
            UserRepository(
                AppDataBase.getDataBase(requireContext().applicationContext).userDao()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateUserNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val username = binding.etCreateUserName.text.toString()
            val password = binding.etCreatePassword.text.toString()

            if (validateInput(username, password)) {
                viewModel.saveUser(username, password)

                binding.etCreateUserName.text.clear()
                binding.etCreatePassword.text.clear()
            }
        }
    }

    private fun validateInput(username: String, password: String): Boolean {
        if (username.isEmpty()) {
            binding.etCreateUserName.error = "Please enter a username"
            return false
        }

        if (password.isEmpty()) {
            binding.etCreatePassword.error = "Please enter a password"
            return false
        }
        return true
    }
}