package com.example.jetpacknavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profile_welcome_text = view.findViewById<TextView>(R.id.profile_welcome_text)


        val currentBackStackEntry = findNavController().currentBackStackEntry
        val savedStateHandle = currentBackStackEntry!!.savedStateHandle

        savedStateHandle.getLiveData<Boolean>(LoginFragment.LOGIN_SUCCESSFUL)
            .observe(currentBackStackEntry) {
                if (!it) {
                    findNavController().popBackStack()
                }
            }


        if (UserLoginInfo.user == null) {
            findNavController().navigate(R.id.loginFragment,null)

        } else {
            val username = UserLoginInfo.user!!.username
            Toast.makeText(requireContext(), "Hi, $username", Toast.LENGTH_SHORT).show()
            profile_welcome_text.text = getString(R.string.welcome_to_your_profile, username)
        }

    }
}