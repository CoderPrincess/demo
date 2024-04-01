package com.example.taskbottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskbottomnav.databinding.FragmentUserNameListBinding
import kotlinx.coroutines.launch

class UserNameListFragment : Fragment(R.layout.fragment_user_name_list) {

    private lateinit var binding: FragmentUserNameListBinding
    private lateinit var adapter: UserNameListAdapter

    private val viewModel: UserNameListViewModel by viewModels {
        UserNameListViewModelFactory(
            requireActivity().application,
            UserRepository(
                AppDataBase.getDataBase(requireContext().applicationContext).userDao()
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserNameListBinding.bind(view)

        adapter = UserNameListAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.userList.collect { userList: List<UserDataClass> ->
                adapter.submitList(userList)
            }
        }
        }
}