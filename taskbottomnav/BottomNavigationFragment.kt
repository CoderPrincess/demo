package com.example.taskbottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class BottomNavigationFragment : Fragment() {

    override fun onCreateView (inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_bottom_navigation, container,false)
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)
    }
}

// childFragmentManager return private FragmentManger for placing and managing Fragments inside of this Fragment.
// NavHostFragment is a container for hosting navigation within the fragment.
// NavController is responsible for managing navigation within the navigation graph. It's retrieved from the NavHostFragment.
// setupWithNavController - The selected item in the NavigationView will automatically be updated when the destination changes.