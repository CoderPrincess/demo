package com.example.taskbottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taskbottomnav.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var userDao: UserDataAccessObject

    private val viewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(
            requireActivity().application,
            UserRepository(
                AppDataBase.getDataBase(requireContext().applicationContext).userDao()
            )
        )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        userDao = AppDataBase.getDataBase(requireContext()).userDao()

        binding.btnLogin.setOnClickListener {
            val userName = binding.etLoginUserName.text.toString().trim()
            val password = binding.etLoginPassword.text.toString().trim()

            if (validateInputs(userName, password)) {
                viewModel.loginUser(userName, password)

                binding.etLoginUserName.text.clear()
                binding.etLoginPassword.text.clear()
            }
        }

        viewModel.loginResult.observe(viewLifecycleOwner) { result ->
            if (result) {
                findNavController().navigate(R.id.action_loginFragment_to_bottomNavigationFragment)
            } else {
                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()


            }
        }
    }

    private fun validateInputs(userName: String, password: String): Boolean {
        if (userName.isEmpty()) {
            binding.etLoginUserName.error = "Please enter a username"
            return false
        }

        if (password.isEmpty()) {
            binding.etLoginPassword.error = "Please enter a password"
            return false
        }
        return true
    }
}